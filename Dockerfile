FROM java:8
COPY ./target/ItemizedBillApplication-0.0.1-SNAPSHOT.jar /usr/src/item/
WORKDIR /usr/src/item
EXPOSE 9002
CMD ["java", "-jar", "ItemizedBillApplication-0.0.1-SNAPSHOT.jar"]
