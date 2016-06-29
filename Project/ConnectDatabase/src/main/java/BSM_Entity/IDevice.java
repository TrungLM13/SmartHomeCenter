package BSM_Entity;

public class IDevice {
	
	private	String	m_DeviceID;
	private	String	m_DeviceName;
	private	String	m_Location;
	private int		m_Status;
	
	public IDevice(){
		m_DeviceID		= "";
		m_DeviceName	= "";
		m_Location		= "";
		m_Status		= IStatus.OK;
	}
	
	public IDevice(String id, String name, String location, int status){
		m_DeviceID		=	id;
		m_DeviceName	=	name;
		m_Location		=	location;
		m_Status		=	status;
	}

	public String getM_DeviceID() {
		return m_DeviceID;
	}

	public void setM_DeviceID(String m_DeviceID) {
		this.m_DeviceID = m_DeviceID;
	}

	public String getM_DeviceName() {
		return m_DeviceName;
	}

	public void setM_DeviceName(String m_DeviceName) {
		this.m_DeviceName = m_DeviceName;
	}

	public String getM_Location() {
		return m_Location;
	}

	public void setM_Location(String m_Location) {
		this.m_Location = m_Location;
	}

	public int getM_Status() {
		return m_Status;
	}

	public void setM_Status(int m_Status) {
		this.m_Status = m_Status;
	}

}
