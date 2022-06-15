import org.junit.*;


public class ShipmentBOJUnit {
ShipmentBO shipmentBO;
Shipment shipment;
ShipmentDAO shipmentDAO;


@Before
public void createObjectForShipmentEntity()
{
//fill code here. 
	shipment = new Shipment(10, "shipment1", "oh", "NV", 444,
			new ShipmentStatus(20, "inprogress", 222));
	shipmentDAO = new ShipmentDAO();
shipmentBO = new ShipmentBO();



}

@Test
public void testUpdateShipment() throws Exception
{
	//fill code here.
	shipmentBO.updateShipment(1, 12, shipmentDAO);

}

@Test(expected = Exception.class)
public void testUpdateShipment_failure() throws Exception
{
	shipmentBO.updateShipment(20, 22, shipmentDAO);
}

@Test
public void testAddShipment() throws Exception
{
	shipmentBO.addShipment(shipment, 12, shipmentDAO);
}

@Test(expected = Exception.class)
public void testAddShipment_failure() throws Exception
{
	shipmentBO.addShipment(shipment, 20, shipmentDAO);
}

} 
