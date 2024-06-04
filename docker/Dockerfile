ARG UBUNTU_VERSION
FROM ubuntu:${UBUNTU_VERSION}
USER root

ARG TARGET_GCC_PACKAGE
ARG TARGET_GCC_EXEC

RUN apt-get update -y && \
    apt-get install -y \
        curl wget ca-certificates-java \
        make cmake ${TARGET_GCC_PACKAGE} && \
    apt-get clean

RUN update-alternatives --install /usr/bin/cc cc /usr/bin/${TARGET_GCC_EXEC}-gcc 999 && \
    update-alternatives --install /usr/bin/c++ c++ /usr/bin/${TARGET_GCC_EXEC}-g++ 999

RUN printf '\xfe\xed\xfe\xed\x00\x00\x00\x02\x00\x00\x00\x00\xe2\x68\x6e\x45\xfb\x43\xdf\xa4\xd9\x92\xdd\x41\xce\xb6\xb2\x1c\x63\x30\xd7\x92' > /etc/ssl/certs/java/cacerts && \
    /var/lib/dpkg/info/ca-certificates-java.postinst configure \

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