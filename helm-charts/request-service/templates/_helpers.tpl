{{- define "request-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "request-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "request-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "request-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "request-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "request-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "request-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
