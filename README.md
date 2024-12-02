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
- **GET** `/api/clientes` - Listar todos los clientes.
- **POST** `/api/clientes` - Crear un nuevo cliente.
- **GET** `/api/clientes/{id}` - Obtener un cliente por ID.

### **Producto**
- **GET** `/api/productos` - Listar todos los productos.
- **POST** `/api/productos` - Crear un nuevo producto.
- **GET** `/api/productos/{id}` - Obtener un producto por ID.

### **Pedido**
- **GET** `/api/pedidos` - Listar todos los pedidos.
- **POST** `/api/pedidos` - Crear un nuevo pedido.

### **Comprobante**
- **POST** `/api/comprobantes` - Crear un nuevo comprobante.
  - **Body**: Lista de IDs de pedidos.
  - **Query Param**: `clienteId`.
- **GET** `/api/comprobantes` - Listar todos los comprobantes.
- **GET** `/api/comprobantes/{id}` - Obtener un comprobante por ID.
- 
