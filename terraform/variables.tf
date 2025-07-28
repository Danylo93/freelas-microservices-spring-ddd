variable "location" {
  type        = string
  description = "Azure region"
  default     = "eastus"
}

variable "resource_group_name" {
  type        = string
  description = "Resource group name"
  default     = "freelas-rg"
}

variable "cluster_name" {
  type        = string
  description = "AKS cluster name"
  default     = "freelas-aks"
}

variable "dns_prefix" {
  type        = string
  description = "DNS prefix for AKS"
  default     = "freelas"
}

variable "node_count" {
  type        = number
  description = "Number of nodes in the default pool"
  default     = 2
}
