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
