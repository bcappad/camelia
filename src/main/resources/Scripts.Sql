CREATE TABLE `category` (
  `id_category` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_category`);

INSERT INTO `category` VALUES (1,'juguetes'),(2,'lencerias'),(3,'aromaticas'),(5,'varios'),(8,'indumentaria');

CREATE TABLE `customer` (
  `id_customer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `whatsap` varchar(45) NOT NULL,
  `observations` varchar(60) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`id_customer`);

 INSERT INTO `customer` VALUES (1,'juana Gonzalez','pellegrini 26','341568574','ninguna','1996-01-29'),(3,'Pedro Gomez','Rodriguez 56','341584586','le gustan bla bla','1989-06-17'),(4,'Juliana Soulé','Sarmiento 1191 - San Nicolas 2900','33647512','compra normalemnte prod1','1976-11-15');

 CREATE TABLE `invoice` (
   `id_invoice` int NOT NULL AUTO_INCREMENT,
   `id_payment_method` int DEFAULT NULL,
   `id_user` int DEFAULT NULL,
   `final_amount` double DEFAULT NULL,
   `observation` varchar(120) DEFAULT NULL,
   `transaction_date` date DEFAULT NULL,
   PRIMARY KEY (`id_invoice`),
   KEY `fk_invoice_payment_method` (`id_payment_method`),
   KEY `fk_invoice_user` (`id_user`),
   CONSTRAINT `fk_invoice_payment_method` FOREIGN KEY (`id_payment_method`) REFERENCES `payment_method` (`id_payment_method`),
   CONSTRAINT `fk_invoice_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

  INSERT INTO `invoice` VALUES (1,1,1,100,'',NULL),(2,1,2,0,NULL,NULL),(3,2,1,0,NULL,NULL),(4,3,1,0,NULL,NULL),(5,1,2,0,NULL,NULL);

  CREATE TABLE `payment_method` (
    `id_payment_method` int NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`id_payment_method`);

   INSERT INTO `payment_method` VALUES (1,'efectivo'),(2,'deposito bancario'),(3,'debito/credito'),(4,'billetera virtual'),(5,'otros');

   CREATE TABLE `product` (
     `id_product` int NOT NULL AUTO_INCREMENT,
     `name` varchar(45) NOT NULL,
     `model` varchar(45) DEFAULT NULL,
     `id_provider` int NOT NULL,
     `id_category` int NOT NULL,
     `specification` varchar(255) DEFAULT NULL,
     `stock` int NOT NULL,
     `price` double NOT NULL,
     PRIMARY KEY (`id_product`),
     KEY `fk_product_provider` (`id_provider`),
     KEY `fk_product_category` (`id_category`),
     CONSTRAINT `fk_product_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
     CONSTRAINT `fk_product_provider` FOREIGN KEY (`id_provider`) REFERENCES `provider` (`id_provider`);

    INSERT INTO `product` VALUES (1,'producto 1','blanco',1,1,NULL,20,0),(2,'prod2','blanco',1,1,NULL,1,0),(3,'prod3',NULL,2,1,NULL,0,0),(4,'prod4','rojo',2,2,NULL,15,0),(5,'prod5','rojo',3,3,NULL,6,0),(6,'prod6',NULL,1,3,NULL,150,0),(7,'producto nuevo 235','Rosa',1,1,'nueva versión',5,120),(9,'prod borrar','ko',1,1,NULL,2,100);

    CREATE TABLE `provider` (
      `id_provider` int NOT NULL AUTO_INCREMENT,
      `name` varchar(50) NOT NULL,
      `tradename` varchar(50) NOT NULL,
      `cuit` varchar(50) NOT NULL,
      `email` varchar(80) DEFAULT NULL,
      `phone_number` varchar(50) NOT NULL,
      `whatsap` varchar(50) DEFAULT NULL,
      `comments` varchar(50) DEFAULT NULL,
      `address` varchar(50) NOT NULL,
      `mail` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id_provider`);

     INSERT INTO `provider` VALUES (1,'proovedor 1','nono','30-2515691-2','noo@juano.com','01115645969','01195674','jshduh','juan canals 5254',NULL),(2,'prov 2','uju','30-651492-2','uju@gmail.com','01154455','14566544',NULL,'linio funes 54',NULL),(3,'prov 3','oyola','30-55246411-1','oyola@gmail.com','01154756','5456655',NULL,'kdijsjsfl',NULL);

     CREATE TABLE `sale` (
       `id_sale` int NOT NULL AUTO_INCREMENT,
       `id_product` int NOT NULL,
       `quantity` int NOT NULL,
       `id_invoice` int DEFAULT NULL,
       PRIMARY KEY (`id_sale`),
       KEY `fk_sales_product` (`id_product`),
       KEY `fk_sale_invoice` (`id_invoice`),
       CONSTRAINT `fk_sale_invoice` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id_invoice`),
       CONSTRAINT `fk_sales_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

      INSERT INTO `sale` VALUES (1,1,1,1),(2,2,2,1),(3,3,1,1),(4,1,1,1),(5,5,2,2),(6,7,3,3),(7,5,2,3),(8,1,2,4);

      CREATE TABLE `user` (
        `id_user` int NOT NULL AUTO_INCREMENT,
        `user` varchar(50) NOT NULL,
        `password` varchar(50) NOT NULL,
        `name` varchar(50) NOT NULL,
        `last_name` varchar(50) NOT NULL,
        `id_user_role` int DEFAULT NULL,
        PRIMARY KEY (`id_user`),
        KEY `fk_user_user_role` (`id_user_role`),
        CONSTRAINT `fk_user_user_role` FOREIGN KEY (`id_user_role`) REFERENCES `user_role` (`id_user_role`);

       INSERT INTO `user` VALUES (1,'larakolumbic','laralara','Lara','Kolumbic',1),(2,'brendac','brenbren','Brenda','Cap',2),(3,'juanap','juanajuana','Juana','Perez',2),(4,'pedror','pedropedro','Pedro','Rodriguez',2),(5,'juanajuana','jojo','Juana','Perez',2),(6,'romina1','jojojojo','Romina','Gomez',2),(7,'Juan26','jojojojo','Juan','Gomez',2);

       CREATE TABLE `user_role` (
         `id_user_role` int NOT NULL AUTO_INCREMENT,
         `role_name` varchar(50) NOT NULL,
         PRIMARY KEY (`id_user_role`);

        INSERT INTO `user_role` VALUES (1,'admin'),(2,'vendedor');
