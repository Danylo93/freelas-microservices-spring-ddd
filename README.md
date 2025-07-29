# freelas-microservices-spring-ddd

Este repositório contém um conjunto de microserviços Spring Boot utilizando DDD. O projeto agora está preparado para ser implantado em Azure Kubernetes Service (AKS) por meio de Terraform e possui pipeline de CI/CD utilizando GitHub Actions.

## Terraform (Azure)
O diretório `terraform` provê os recursos necessários para criação de um cluster AKS básico. Para inicializar e validar a infraestrutura:

```bash
terraform -chdir=terraform init
terraform -chdir=terraform validate
```

## CI/CD
O workflow padrão em `.github/workflows/ci-cd.yml` executa build e testes de todos os microserviços e gera o plano do Terraform a cada `push` ou `pull_request` para a branch `main`.

## Implantação com Helm e Kubernetes
Após a criação do cluster, aplique os manifestos base e instale os charts de cada serviço:

```bash
# recursos de namespace e ingress controller
kubectl apply -k k8s/base

# instalar ou atualizar os serviços
for svc in billing client gateway matching notification provider request; do
  helm upgrade --install "${svc}-service" "./helm-charts/${svc}-service" \
    --namespace freelas-dev \
    --values "./k8s/overlays/dev/values-dev-${svc}-service.yaml"
done
```

Ao final, confira os ingressos criados com:

```bash
kubectl get ingress -n freelas-dev
```

## Ambiente local com Docker Compose

Para executar toda a stack em modo de desenvolvimento é fornecido um arquivo
`docker-compose.yml` no diretório `micro-services`. Este compose cria uma
instância do Kafka e um banco PostgreSQL dedicado para cada microserviço.

Execute os serviços com:

```bash
cd micro-services
docker compose up --build
```

Após o provisionamento os serviços podem ser acessados nas portas abaixo:

| Serviço            | Porta |
|--------------------|-------|
| Gateway            | 8090  |
| Provider           | 8081  |
| Request            | 8082  |
| Client             | 8083  |
| Billing            | 8084  |
| Notification       | 8099  |
| Matching           | 8086  |

O gateway já é configurado para se comunicar com os demais contêineres por meio
dos nomes de serviço do Docker Compose. Caso queira alterar algum endereço,
sobrescreva as variáveis de ambiente `PROVIDER_SERVICE_URL`,
`REQUEST_SERVICE_URL`, `NOTIFICATION_SERVICE_URL`, `CLIENT_SERVICE_URL` ou
`BILLING_SERVICE_URL` ao subir o `gateway-service`.

