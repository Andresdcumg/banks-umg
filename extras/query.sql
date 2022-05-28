CREATE TABLE "banco" (
  "IdBanco" SERIAL,
  "direccion" varchar(60),
  "telefono" varchar(30),
  "nombre" varchar(100),
  PRIMARY KEY ("IdBanco")
);

CREATE TABLE "cliente" (
  "IdCliente" SERIAL,
  "nombre" varchar(30),
  "apellido" varchar(30),
  "direccion" varchar(60),
  "telefono" varchar(30),
  "IdBanco" SERIAL,
  "password" varchar(30),
  "email" varchar(50),
  PRIMARY KEY ("IdCliente"),
  CONSTRAINT "FK_cliente.IdBanco"
    FOREIGN KEY ("IdBanco")
      REFERENCES "banco"("IdBanco")
);

CREATE TABLE "cuenta" (
  "IdCuenta" SERIAL,
  "IdCliente" SERIAL,
  "tipo" varchar(40),
  "saldo" dec,
  PRIMARY KEY ("IdCuenta"),
  CONSTRAINT "FK_cuenta.IdCliente"
    FOREIGN KEY ("IdCliente")
      REFERENCES "cliente"("IdCliente")
);

CREATE TABLE "prestamo" (
  "IdPrestamo" SERIAL,
  "IdCliente" SERIAL,
  "monto" dec,
  "saldo" dec,
  "pago" date,
  PRIMARY KEY ("IdPrestamo"),
  CONSTRAINT "FK_prestamo.IdCliente"
    FOREIGN KEY ("IdCliente")
      REFERENCES "cliente"("IdCliente")
);

CREATE TABLE "servicio" (
  "IdServicio" SERIAL,
  "tipo" varchar(20),
  "verificador" varchar(20),
  PRIMARY KEY ("IdServicio")
);

CREATE TABLE "pago" (
  "IdPago" SERIAL,
  "IdPrestamo" SERIAL,
  "IdServicio" SERIAL,
  "IdCuenta" SERIAL,
  "correlativo" varchar(30),
  "monto" dec,
  "fecha" date,
  PRIMARY KEY ("IdPago"),
  CONSTRAINT "FK_pago.IdCuenta"
    FOREIGN KEY ("IdCuenta")
      REFERENCES "cuenta"("IdCuenta"),
  CONSTRAINT "FK_pago.IdPrestamo"
    FOREIGN KEY ("IdPrestamo")
      REFERENCES "prestamo"("IdPrestamo"),
  CONSTRAINT "FK_pago.IdServicio"
    FOREIGN KEY ("IdServicio")
      REFERENCES "servicio"("IdServicio")
);

CREATE TABLE "transferencia" (
  "IdTransferencia" SERIAL,
  "cuentaDebito" SERIAL,
  "cuentaCredito" SERIAL,
  "tipo" varchar(20),
  "IdBanco" int,
  "monto" dec,
  "creadoEl" date,
  "aceptadaEl" date,
  "rechazadaEl" date,
  PRIMARY KEY ("IdTransferencia"),
  CONSTRAINT "FK_transferencia.cuentaDebito"
    FOREIGN KEY ("cuentaDebito")
      REFERENCES "cuenta"("IdCuenta"),
  CONSTRAINT "FK_transferencia.IdBanco"
    FOREIGN KEY ("IdBanco")
      REFERENCES "banco"("IdBanco"),
  CONSTRAINT "FK_transferencia.cuentaCredito"
    FOREIGN KEY ("cuentaCredito")
      REFERENCES "cuenta"("IdCuenta")
);

CREATE TABLE "cheque" (
  "Idcheque" SERIAL,
  "IdCuenta" SERIAL,
  "receptor" varchar(100),
  "creadoEl" date,
  "cobradoEl" date,
  "rechazadoEl" date,
  "monto" dec,
  PRIMARY KEY ("Idcheque"),
  CONSTRAINT "FK_cheque.IdCuenta"
    FOREIGN KEY ("IdCuenta")
      REFERENCES "cuenta"("IdCuenta")
);

CREATE TABLE "tarjeta" (
  "IdTarjeta" SERIAL,
  "numero" int,
  "vencimiento" date,
  "titular" varchar(20),
  "ccv" int,
  "IdCliente" SERIAL,
  "montoAutorizado" dec,
  "montoUsado" dec,
  "corte" date,
  "pago" date,
  PRIMARY KEY ("IdTarjeta"),
  CONSTRAINT "FK_tarjeta.IdCliente"
    FOREIGN KEY ("IdCliente")
      REFERENCES "cliente"("IdCliente")
);

CREATE TABLE "sugerencia" (
  "IdSugerencia" SERIAL,
  "nombre" varchar(30),
  "comentario" text,
  "ip" varchar(30),
  "email" varchar(50),
  PRIMARY KEY ("IdSugerencia")
);