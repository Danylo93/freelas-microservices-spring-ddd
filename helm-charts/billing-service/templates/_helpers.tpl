{{- define "billing-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "billing-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "billing-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "billing-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "billing-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "billing-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "billing-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
