FROM node:14-alpine

RUN npm install -g @mockoon/cli@latest
COPY webhook-mock.json ./data

# Do not run as root.
RUN adduser --shell /bin/sh --disabled-password --gecos "" mockoon
USER mockoon


EXPOSE 9999

ENTRYPOINT ["mockoon-cli", "start", "--hostname", "0.0.0.0", "--data", "data", "-t"]
