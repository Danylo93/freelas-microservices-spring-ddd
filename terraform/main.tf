provider "aws" {
  region = var.aws_region
}

module "eks" {
  source          = "terraform-aws-modules/eks/aws"
  cluster_name    = var.cluster_name
  cluster_version = "1.27"

  subnet_ids = module.vpc.private_subnets

  vpc_id = module.vpc.vpc_id

  manage_aws_auth = true
  enable_irsa     = true

  node_groups = {
    default = {
      desired_capacity = 2
      max_capacity     = 4
      min_capacity     = 1

      instance_type = "t3.medium"
    }
  }
}