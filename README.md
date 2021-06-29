# PROYECTO FINAL PARA CURSO DE BACKEND CON JAVA DE ADAITW

### Introducción
Actualmente el comercio Camelia se maneja con documentación toda en papel y planillas de excel, sin tener un correcto registro de stock de mercadería y de las ventas.
Para poder tener mayor control y orden se quiere implementar un sistema que permita tener seguimiento de las ventas y del stock de mercadería.
Con la implementación del sistema se espera mejorar el control de mercadería existente y poder calcular también de manera más exacta las cantidades para reposición.
Además se desea tener una base de datos organizada de los clientes frecuentes para tener políticas de retención.

### Objetivos
* Garantizar el acceso al stock de mercadería y poder tenerlo organizado.
* Tener la posibilidad de organizar la compra de nueva mercadería en base al historial de ventas.
* Tener registro de las ventas.
* Tener una base de datos de clientes.

### Requisitos
* Se necesita hacer un sistema API REST con una base de datos relacional en MySQL.
* El sistema a utilizar es Java 11 con Maven y SpringBoot.

### Reglas de negocio
El sistema será utilizado por los vendedores y la administradora del local para tener seguimiento de las ventas y stock de productos.
- Cada vendedor tiene asignado un usuario con nombre de usuario, nombre, apellido y contraseña. La contraseña debe tener al menos 6 caracteres.
- Sólo el usuario con rol administrador tiene habilitada la posibilidad de actualizar el stock e información de los productos.
- Cada producto está asociado a una categoría.
- Cada producto está asociado a su respectivo proveedor.
- Cada venta contiene fecha, el vendedor que la realiza y los productos. Debe imprimir un comprobante de compra con el monto a pagar.
- Se dispone de una base de datos de clientes.

### Diagrama de entidad-relación

[Link al diagrama](https://drive.google.com/file/d/1-OXkIRL7AHRstlEck4p25t928cI-Hfwq/view?usp=sharing)


### Diccionario de datos

Tabla: PRODUCT
Campos:
id_product: identificador del producto (int not null autoincremental)
id_provider: identificador del proveedor al cuál se le compra el producto (int not null)
id_category: identificador de la categoría a la que pertenece el producto (int not null)
name: nombre del producto (string 45)
model: modelo del producto (string 45)
price: el precio de venta del producto (double)
stock: cantidad disponible del producto (int not null)
relaciones: se relaciona con provider. Cada producto se asocia con el o los proveedores que proveen el producto.
Se relaciona con category. Cada producto se asocia con una categoría determinada.

Tabla: CATEGORY
Campos:
id_category: identificador de la categoría (int not null autoincremental)
name: nombre de la categoría (string 50)

Tabla: CUSTOMER
Campos:
id_customer: identificador de del cliente (int not null autoincremental)
name: nombre del cliente (string 45)
address: dirección del cliente (string 45)
whatsapp: número de contacto por whatsapp del cliente (string 45)
birthdate: fecha de nacimiento del cliente (date)
observations: espacio para que los vendedores puedan hacer anotaciones (string 60)

Tabla: USER
Campos:
id_user: identificador del usuario (int not null autoincremental)
user: nombre de usuario para ingresar al sistema, sólo debe contener caracteres alfanuméricos (string 50)
password: contraseña para ingresar al sistema, puede tener letras, símbolos y números (string 50)
name: nombre del usuario (string 50)
last_name: apellido del usuario (string 50)


Tabla: INVOICE
Campos:
id_invoice: identificador de la factura de venta (int not null autoincremental)
date: fecha en que se realiza la venta (date)
id_payment_method: identificador del tipo de pago (int not null)
id_user: identificador del usuario que realiza la venta (int not null)
final_amount: suma a pagar, resultado de la suma de todos los productos a comprar (double)
Relaciones: se relaciona con payment_method y user.

Tabla: SALE
Campos:
id_sale: identificador de la venta (int not null autoincremental)
id_product: identificador del producto incluído en la venta (int not null)
id_invoice: identificador de la factura a la que corresponde la venta (int not null)
quantity: cantidad de productos a vender (int not null)
Relaciones: se relaciona con productos e invoice.

Tabla: PAYMENT_METHOD
Campos:
id_payment_method: identificador del tipo de pago (int not null autoincremental)
name: nombre que especifica el tipo de pago (string)

Tabla:PROVIDER
Campos:
id_provider: identificador de la categoría (int not null autoincremental)
name: razón social del proveedor (string 50)
tradename: nombre comercial del proveedor (string 50)
cuit: código de identificación tributaria del proveedor (string 50)
mail: correo electrónico del proveedor (50)
phone_number: número de teléfono del proveedor (string 50)
whatsap: número de contacto por whatsapp del proveedor (string 50)
address: dirección del proveedor (string 50)
comments: espacio para dejar observaciones sobre el proveedor (string 50)
