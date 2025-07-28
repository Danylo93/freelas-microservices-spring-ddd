{{- define "provider-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "provider-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "provider-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "provider-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "provider-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "provider-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "provider-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
