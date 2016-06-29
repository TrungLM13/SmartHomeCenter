package BSM_Entity;

public class IPower {
	private String	m_DeviceID;
	private String 	m_DeviceName;
	private String 	m_Month;
	private int		m_TimeConsumtion;
	private int		m_PowerConsumtion;
	
	public IPower(){
		m_DeviceID 			=	"";
		m_DeviceName		=	"";
		m_Month				=	"";
		m_TimeConsumtion	=	0;
		m_PowerConsumtion	=	0;
	}
	
	public IPower(String ID, String name, String month, int timeCon, int powerCon){
		m_DeviceID			=	ID;
		m_DeviceName		=	name;
		m_Month				=	month;
		m_TimeConsumtion	=	timeCon;
		m_PowerConsumtion	=	powerCon;
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

	public String getM_Month() {
		return m_Month;
	}

	public void setM_Month(String m_Month) {
		this.m_Month = m_Month;
	}

	public int getM_TimeConsumtion() {
		return m_TimeConsumtion;
	}

	public void setM_TimeConsumtion(int m_TimeConsumtion) {
		this.m_TimeConsumtion = m_TimeConsumtion;
	}

	public int getM_PowerConsumtion() {
		return m_PowerConsumtion;
	}

	public void setM_PowerConsumtion(int m_PowerConsumtion) {
		this.m_PowerConsumtion = m_PowerConsumtion;
	}
}
