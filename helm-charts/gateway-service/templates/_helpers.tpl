{{- define "gateway-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "gateway-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "gateway-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "gateway-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "gateway-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "gateway-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "gateway-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
