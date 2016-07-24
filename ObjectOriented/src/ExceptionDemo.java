class CheckRadiusExp extends Exception
/* ���������쳣��CheckRadiusExp�̳�Exception */
{
	/* ����˽���ַ�����Ա�����洢��Ϣ��Ϣ */
	private String message;

	/* ����ղι��캯�� */
	public CheckRadiusExp() {
	}

	/* �����вι��캯�� */
	public CheckRadiusExp(String msg) {/* ���ø�ֵ���� */
		this.setMessage(msg);
	}

	/* ��ӡ������Ϣ */
	public void expLog() {
		System.out.println("��Circle���еĵ�48��" + message);
	}

	/* �����ṩ����˽�г�Ա���� */
	public String getMessage() {
		return message;
	}

	/* �����ṩ����˽�г�Աmessage���� */
	public void setMessage(String message) {
		this.message = message;
	}
}

/* ������ Բ */
class Circle {
	/* ˽�л���Ա����radius��ʾԲ�İ뾶������ֵPIΪԲ���� */
	private double radius;
	private final double PI = 3.14;

	/* ����Բ���캯������ʼ���뾶ֵ����������쳣��Ϣ�����׳� */
	public Circle(double radius) throws CheckRadiusExp {
		setRadius(radius);
	}

	/* ����˽�г�Ա����ֵ�������ж�ֵ�Ƿ�Ϸ������Ϸ��׳��쳣��Ϣ */
	public void setRadius(double r) throws CheckRadiusExp {
		if (r <= 0) {
			throw new CheckRadiusExp("Բ�İ뾶��" + radius + "Ϊ�Ƿ�ֵ");
		}
		this.radius = r;
	}

	/* �����ṩ����Բ�뾶ֵ�÷��� */
	public double getRadius() {
		return radius;
	}

	/* �����ṩ����Բ��������� */
	public double getArea() {
		return this.radius * this.radius * PI;
	}
}

public class ExceptionDemo {
	public static void main(String[] args) {
		/*
		 * �������󣬳�ʼ��Բ�İ뾶�����Բ�������Ϣ�� ��������쳣��Ϣ������CheckRadiusExp���е�ExpLog������¼��Ϣ
		 */
		try {
			Circle c = new Circle(0);
			System.out.println("Բ�����Ϊ" + c.getArea());
		} catch (CheckRadiusExp cre) {
			cre.expLog();
		} finally {
			System.out.println("Over");
		}
	}
}
