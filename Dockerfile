FROM openjdk:20-slim-buster

RUN addgroup appgroup && adduser --ingroup appgroup --disabled-password appuser
USER appuser

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","co.zero.WizardFormApplication"]
