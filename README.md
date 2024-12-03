# ProyectoJAVA
## Características principales
- **Gestión de comprobantes**:
  - Creación de comprobantes asociados a clientes y pedidos.
  - Cálculo automático del total de la venta y la cantidad de productos vendidos.
  - Validaciones de stock de productos antes de registrar un comprobante.
- **Gestión de clientes**:
  - Asociar comprobantes a clientes existentes.
- **Gestión de productos**:
  - Actualización automática del stock de productos al crear comprobantes.
  - Protección de los precios históricos en comprobantes ya generados.
- **Gestión de pedidos**:
  - Creación de pedidos con referencia a productos y cantidades solicitadas.

---

## Tecnologías utilizadas
- **Backend**: Java, Spring Boot
- **ORM**: Hibernate (JPA)
- **Base de datos**: MySQL (configurable con otras bases de datos)
- **JSON Processing**: Jackson
- **Dependencias adicionales**: Lombok, Spring Data JPA, Spring Web

---

## Endpoints disponibles
### **Cliente**
- **GET** `/api/cliente` - Listar todos los clientes.
- **POST** `/api/cliente` - Crear un nuevo cliente.
- **GET** `/api/cliente/{id}` - Obtener un cliente por ID.

### **Producto**
- **GET** `/api/producto` - Listar todos los productos.
- **POST** `/api/producto` - Crear un nuevo producto.
- **GET** `/api/producto/{id}` - Obtener un producto por ID.

### **Pedido**
- **GET** `/api/pedido` - Listar todos los pedidos.
- **POST** `/api/pedido` - Crear un nuevo pedido.

### **Factura o comprobante**
- **POST** `/api/comprobante` - Crear un nuevo comprobante.
{
    "clienteId": 1,
    "productos": [
        {
            "productoId": 1,
            "cantidad": 3
        },
        {
            "productoId": 2,
            "cantidad": 5
        }
    ]
}
- **GET** `/api/comprobante` - Listar todos los comprobantes.
- **GET** `/api/comprobante/{id}` - Obtener un comprobante por ID.
- 
