// Define global variables
// Set Maven command to always include Nexus Settings
// NOTE: Somehow an inline pod template in a declarative pipeline
//       needs the "scl_enable" before calling maven.
mvnCmd = "source /usr/local/bin/scl_enable && mvn -s ./nexus_settings.xml"

// Images and Projects
imageName   = "${GUID}-tasks"
devProject  = "${GUID}-tasks-dev"
prodProject = "${GUID}-tasks-prod"

// Tags
devTag      = "0.0-0"
prodTag     = "0.0"

// Blue-Green Settings
destApp     = "tasks-green"
activeApp   = ""

// CI/CD Urls
// intClusterUrl    = "svc.cluster.local"
intRegistryUrl   = "image-registry.openshift-image-registry.svc:5000"
sonarqubeUrl     = "homework-sonarqube.gpte-hw-cicd.svc.cluster.local:9000"
nexusRegistryUrl = "homework-nexus-registry.gpte-hw-cicd.svc.cluster.local:5000"
nexusUrl         = "homework-nexus.gpte-hw-cicd.svc.cluster.local:8081"
nexusCreds       = "admin:redhat"
