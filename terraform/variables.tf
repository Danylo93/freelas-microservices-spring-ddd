variable "aws_region" {
  type        = string
  description = "AWS region"
  default     = "us-east-1"
}

variable "cluster_name" {
  type        = string
  description = "EKS cluster name"
  default     = "freelas-cluster"
}

variable "subnet_ids" {
  type        = list(string)
  description = "Subnet IDs for EKS"
}
