{{- define "matching-service.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "matching-service.fullname" -}}
{{- printf "%s-%s" .Release.Name (include "matching-service.name" .) | trunc 63 | trimSuffix "-" -}}
{{- end }}

{{- define "matching-service.labels" -}}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
app.kubernetes.io/name: {{ include "matching-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "matching-service.selectorLabels" -}}
app.kubernetes.io/name: {{ include "matching-service.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
