{{- define "client-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "client-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "client-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "client-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "client-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "client-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "client-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
