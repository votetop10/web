FROM ubuntu

#========================
RUN apt-get update -qqy \
  && apt-get -qqy --no-install-recommends install \
    iproute2 \
    openssh-client ssh-askpass\
    ca-certificates \
    openjdk-8-jdk \
    tar zip unzip \
    wget curl \
    git \
    build-essential \
    less nano tree \
    python python-pip groff \
    rlwrap \
  && rm -rf /var/lib/apt/lists/* \
  && sed -i 's/securerandom\.source=file:\/dev\/random/securerandom\.source=file:\/dev\/urandom/' ./usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/java.security

RUN [ -f "/etc/ssl/certs/java/cacerts" ] || /var/lib/dpkg/info/ca-certificates-java.postinst configure

#==========
# Maven
#==========
ENV MAVEN_VERSION 3.6.0

RUN curl -fsSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV PATH+MAVEN /usr/share/maven/bin:/usr/lib/jvm/java-8-openjdk-amd64
#========================================
# Add normal user with passwordless sudo
#========================================
RUN useradd remoteuser --shell /bin/bash --create-home \
  && usermod -a -G sudo remoteuser \
  && echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
  && echo 'remoteuser:secret' | chpasswd

#===============
# XVFB & FIREFOX
#===============
RUN apt-get update -qqy \
  && apt-get -qqy --no-install-recommends install \
    xvfb firefox \
  && rm -rf /var/lib/apt/lists/*

ENV SCREEN_WIDTH 1360
ENV SCREEN_HEIGHT 1020
ENV SCREEN_DEPTH 24
ENV DISPLAY :99.0
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
#===============
# Google Chrome
#===============
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
 && apt-get update \
 && apt-get install -y fonttools fonts-liberation libappindicator3-1 libxss1 xdg-utils \
 && dpkg -i google-chrome-stable_current_amd64.deb

#==================
# Chrome webdriver
#==================
ENV CHROME_DRIVER_VERSION 2.20
RUN wget --no-verbose -O /tmp/chromedriver_linux64.zip http://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
  && rm -rf /opt/selenium/chromedriver \
  && unzip /tmp/chromedriver_linux64.zip -d /opt/selenium \
  && rm /tmp/chromedriver_linux64.zip \
  && mv /opt/selenium/chromedriver /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION \
  && chmod 755 /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION \
  && ln -fs /opt/selenium/chromedriver-$CHROME_DRIVER_VERSION /usr/bin/chromedriver

RUN mkdir /tmp/.X11-unix
RUN chmod -R go-rwx /tmp/* /tmp/.[!.]*
RUN chmod 1777 /tmp/.X11-unix
RUN chmod 1777 /tmp
USER root

WORKDIR /home/remoteuser/