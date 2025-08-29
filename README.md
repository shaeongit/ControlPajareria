# Programa para el Control de una Pajarería
Este programa está realizado para el Control de una Pajarería. Es una práctica solicitada e intentaremos cumplir con todos los requisitos requeridos. 

## Nombre del proyecto
No nos hemos complicado mucho: **Controlpajareria**

## Breve descripción funcional
 Este programa lleva el control del stock de los pájaros (cantidad, especie, color) y de las ventas a los clientes (dni, teléfono, email, etc). de forma básica que iremos ampliando de forma progresiva. 

## Requisitos para compilar y ejecutar
 Hemos usado Intellij IDEA version Community, por lo que al bajar el proyecto entero debería compilar sin problemas ya que definimos con **maven** los requisitos.
 
## Instrucciones de uso
 En una primera fase los datos no se guardan en fichero (no es un requisito) así que inicialmente cargamos unos datos desde el código de programa. En un futuro se cambiará a ficheros o base de datos según haga falta.
 
 El funcionamiento es sencillo, al iniciar el programa tenemos un menú con las opciones principales:
 === MENÚ PRINCIPAL ===
1. Gestión de clientes
2. Gestión de pájaros
3. Realizar venta
4. Mostrar ventas
5. Salir

Desde ahí podemos ir a **Gestión de clientes**, donde podremos dar de alta, baja, modificar, listar o buscar a los clientes.

En **Gestión de pájaros** podemos dar de Alta, Listar el catálogo, o buscar por especie. 

A la hora de **Realizar venta** debemos introducir el DNI del cliente previamente dado de alta, en ese momento nos muestra el catálogo de los pájaros y elegimos el que queramos vender. Así iremos añadiendo todos los pájaros de esta venta. Para finalizar escribiremos en número cero (0) y pulsamos enter. Al terminar nos dará la suma total.

En la opción 4, **Mostrar Ventas**, podremos ver todas las ventas realizadas.

Estas opciones son las primeras y aunque iremos actualizando el este readme puede estar un poco desactualizado con el código.

 

## Autoría y licencia
MIT License

Copyright (c) 2025 - shaeongit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
