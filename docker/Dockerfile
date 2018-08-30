FROM java:8
COPY ./templates /
COPY ItemizedBillApplication.jar /usr/src/item/
WORKDIR /usr/src/item
EXPOSE 9002
CMD ["java", "-jar", "ItemizedBillApplication.jar"]
