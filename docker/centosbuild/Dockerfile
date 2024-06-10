ARG DOCKER_IMAGE
FROM ${DOCKER_IMAGE}
USER root

ARG TARGET_GCC_PACKAGE
ARG TARGET_GCC_EXEC

RUN yum update -y && \
    yum install -y \
        "make" "cmake" ${TARGET_GCC_PACKAGE} \
        "glibc" "libstdc++"

RUN update-alternatives --install /usr/bin/cc cc /usr/bin/${TARGET_GCC_EXEC}-gcc 999 && \
    update-alternatives --install /usr/bin/c++ c++ /usr/bin/${TARGET_GCC_EXEC}-g++ 999

VOLUME "/opt/java"
ENV JAVA_HOME="/opt/java"
ENV PATH="$JAVA_HOME:$PATH"

VOLUME "/opt/maven"
ENV MAVEN_HOME="/opt/maven"
ENV PATH="$MAVEN_HOME:$PATH"

VOLUME "/data"
WORKDIR "/data"

ENTRYPOINT [ ]
CMD [ "/bin/bash" ]