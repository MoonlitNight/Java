class CheckRadiusExp extends Exception
/* 创建编译异常类CheckRadiusExp继承Exception */
{
	/* 定义私有字符串成员变量存储消息信息 */
	private String message;

	/* 定义空参构造函数 */
	public CheckRadiusExp() {
	}

	/* 定义有参构造函数 */
	public CheckRadiusExp(String msg) {/* 调用赋值方法 */
		this.setMessage(msg);
	}

	/* 打印错误信息 */
	public void expLog() {
		System.out.println("在Circle类中的第48行" + message);
	}

	/* 对外提供访问私有成员方法 */
	public String getMessage() {
		return message;
	}

	/* 对外提供设置私有成员message方法 */
	public void setMessage(String message) {
		this.message = message;
	}
}

/* 定义类 圆 */
class Circle {
	/* 私有化成员变量radius表示圆的半径，常量值PI为圆周率 */
	private double radius;
	private final double PI = 3.14;

	/* 定义圆构造函数，初始化半径值，如果产生异常信息对外抛出 */
	public Circle(double radius) throws CheckRadiusExp {
		setRadius(radius);
	}

	/* 设置私有成员变量值方法，判断值是否合法，不合法抛出异常信息 */
	public void setRadius(double r) throws CheckRadiusExp {
		if (r <= 0) {
			throw new CheckRadiusExp("圆的半径：" + radius + "为非法值");
		}
		this.radius = r;
	}

	/* 对外提供返回圆半径值得方法 */
	public double getRadius() {
		return radius;
	}

	/* 对外提供返回圆的面积方法 */
	public double getArea() {
		return this.radius * this.radius * PI;
	}
}

public class ExceptionDemo {
	public static void main(String[] args) {
		/*
		 * 创建对象，初始化圆的半径，输出圆的面积信息， 如果出现异常信息，调用CheckRadiusExp类中的ExpLog方法记录信息
		 */
		try {
			Circle c = new Circle(0);
			System.out.println("圆的面积为" + c.getArea());
		} catch (CheckRadiusExp cre) {
			cre.expLog();
		} finally {
			System.out.println("Over");
		}
	}
}
