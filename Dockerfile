FROM maven:3-jdk-11
MAINTAINER leo.lou@gov.bc.ca

RUN apt-get update && apt-get install -y git \
 && git clone -b ${BRANCH} ${REPO} /SRC \
 && cd /SRC && mvn ${GOAL} \
 && mv /SRC/*/target/*.war / \
 && chmod o+r $(ls /*.war) \
 && alias distbin="ls /*.war"

LABEL ca.gov.bc.app="$distbin"

CMD ["tail", "-f", "/dev/null"]
