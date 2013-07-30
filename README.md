KaryonCrud
==========

Example Karyon project showing how to build as a war and using custom Guice modules.

Archaius is used for configuration, so Tomcat or your container will need to be started with the applicationId set to 'karyon-crud'. This line can be placed in the setenv.sh in tomcat's bin directory to do it automatically.

export CATALINA_OPTS="-Darchaius.deployment.applicationId=karyon-crud -Darchaius.deployment.environment=dev"
