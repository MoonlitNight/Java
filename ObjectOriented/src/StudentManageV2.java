public class StudentManageV2 {
	public static int [] id;//������������id���ѧ��ѧ��
	public static String [] name;//�����ַ�����������name���ѧ������
	public static double [] score;//����double��������score���ѧ���ɼ�
	public static int index=0;//��ȡ��������
	public static void main(String[] args) 
	{
		Initialization();
	}
	public static void Initialization()//��ʼ������
	{
		System.out.println("��ʼ������ϵͳ�洢�����������벢���س�ȷ�ϣ�");
		int data=returnInt();//��������
		id=new int [data];//��ʼ��id������ѧ��ѧ��
		name=new String [data];//��ʼ��name������ѧ������
		score=new double[data];//��ʼ��score������ѧ���ɼ�
		choose();//���ù��ܺ���
	}
	public static void choose()//ѡ���ܺ���
	{
		ui();//��ʾ����
		switch(returnInt())
		{
		case 1:add();break;//����ֵΪ1ʱ�������ѧ����Ϣ����
		case 2:revised();break;//����ֵΪ2ʱ�����޸Ĺ���
		case 3:del();break;//����ֵΪ3ʱ����ɾ������
		case 4:search();break;//����ֵΪ4ʱ���ü�������
		case 5:System.exit(0);break;//�����˳�����
		default:System.out.println("������Ϣ������������");
		choose();//����ֵ���󣬷��ع���ѡ�����
		}
	}
	public static void ui()//���湦�ܲ���
	{
		String [] array={"\n\n"+
				                  "******************************ѧ������ϵͳ******************************",
				                  "1�����ѧ����Ϣ",
				                  "2���޸�ѧ����Ϣ",
				                  "3��ɾ��ѧ����Ϣ",
				                  "4����ѯѧ����Ϣ",
				                  "5���˳�����ϵͳ",
				                  "************************************************************************"};//�����������
		for(int i=0;i<array.length;i++)//�������
		{
			System.out.println(array[i]);//��ӡ
		}	
	}
	//��ӹ��ܲ��֣�����������������int����ѧ�š�String���͵�������double���ͳɼ���¼������
		public static void add()//�����Ϣ���ܺ���
		{
			System.out.println("\n\n"+"******************************���ѧ����Ϣ******************************");//��ӡ���
			System.out.print("������ѧ��ѧ�ţ�");//��ӡ���
			id[index]=returnInt();//¼��ѧ����Ϣ��Ž�����
	        System.out.print("������ѧ��������");
	        name[index]=returnString();//¼��������Ϣ��Ž�����
	        System.out.print("������ѧ���ɼ���");//��ӡ���
	        score[index]=returnDouble();//¼�������Ϣ��Ž�����
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//�ж���Ϣ�Ƿ���Ϲ���
	        {
	        	index++;//������һ
	        	System.out.println("ѧ����Ϣ������");
	        	System.out.println("************************************************************************");
	        }else
	        {
	        	defaultValue(index);//�����Ϲ���ָ�Ĭ��ֵ
	    		System.out.println("ѧ����Ϣ��Ӵ�������������");//��ӡ������Ϣ
	    		System.out.println("************************************************************************");
	        }
	        choose();//����ѡ���ܺ���
	        }
		public static void revised()//��Ϣ�޸ĺ���
		{
			System.out.println("������ѧ���޸���Ϣ");
			int i=findKey(returnInt());//���ò��Һ��������ز��ҵ�������ֵ
			if(i>=0)//�ж�ֵ�Ƿ��ҵ�
				{
				System.out.print("�������޸�ѧ�ţ�");//��ӡ���
				id[i]=returnInt();//¼��ѧ����Ϣ��Ž�����
				System.out.print("�������޸�������");
				name[i]=returnString();//¼��������Ϣ��Ž�����
				System.out.print("�������޸ĳɼ���");//��ӡ���
				score[i]=returnDouble();//¼�������Ϣ��Ž�����
				if(id[i]>0&&name[i]!=null&&score[i]>=0)//�ж���Ϣ�Ƿ��������
					{
					System.out.println("ѧ����Ϣ�޸����");
					}else
					{
						defaultValue(i);
						System.out.println("ѧ����Ϣ�޸Ĵ�������������");//��ӡ������Ϣ
					}
				}else 
				{
					System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");  //���û�ҵ�����ʾδ�ҵ� 
				}
			choose();//����ѡ���ܺ���
		}
		public static void del()//��Ϣɾ������
		{
			System.out.println("������ѧ��ɾ����Ϣ");
			int i=findKey(returnInt());//���ò��Һ��������ز��ҵ�������ֵ
			if(i>=0)//�ж��Ƿ��ҵ�
			{
				move(i);//����Ҫɾ�����ƶ������һλ���ָ�Ĭ��ֵ���Ǳ�index��
				System.out.println("ѧ����Ϣ��ɾ��");//��ӡ��Ϣ 
			}else
			{
				System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");//���û�ҵ�����ʾδ�ҵ�
			}
			choose();//����ѡ���ܺ���
		}
		public static void move(int findKey)//��Ϣ�ƶ�����
		{
			for(int i=findKey;i<index-1;i++)
			{
				transoposition(id,name,score,i);//��λ	
			}
			defaultValue(index);
			index-=1;
		}
		public static void defaultValue(int i)//�ָ�Ĭ��ֵ����
		{
			id[i]=0;//���ݳ�ʼ��
			name[i]=null;//���ݳ�ʼ��
			score[i]=0.0;//���ݳ�ʼ��
		}
		//��Ӽ������ܣ����󣬸���¼����ֵ���жϲ�ѯ��ʽ���������Ӧ��Ϣ
		//�޷�����ֵ
		 public static void search()//��Ϣ��������
		 {
			 System.out.println("\n\n"+ "******************************��ѯѧ����Ϣ******************************"+
		                                              "\n"+"1����ѯȫ��ѧ����Ϣ"+
		                                              "\n"+"2����ѧ�Ų�ѯѧ����Ϣ"+
		                                              "\n"+"3����������ѯѧ����Ϣ"+
		                                              "\n"+"4����ѧ���ɼ���ʾѧ����Ϣ������"+
		                                              "\n"+"************************************************************************");//�����Ϣ
			 System.out.println("��ѡ���ѯ��ʽ");//��ӡ�����Ϣ
			 switch(returnInt())
				{
				case 1:searchAll();break;//����ֵΪ1ʱ��ѯȫ��ѧ����Ϣ
				case 2:searchId();break;//����ֵΪ2ʱ��ѧ�Ų�ѯѧ����Ϣ
				case 3:searchName();break;//����ֵΪ3ʱ��������ѯѧ����Ϣ
				case 4:searchDown();break;//����ֵΪ4ʱ��ѧ���ɼ���ʾѧ����Ϣ������
				default:System.out.println("������Ϣ������������");
				choose();//����ֵ���󣬷��ع���ѡ�����
				}
		 }
		 public static void searchAll()
		 {
			 for(int i=0;i<index;i++)
			 {
				 System.out.println("ѧ�ţ�"+id[i]+"\t\t"+"������"+name[i]+"\t\t"+ "�ɼ���"+ score[i]);
			 }		
			 choose();
		 }
		 public static void searchId()
		 {
			 System.out.println("������ѧ��ѧ�ţ�");
			 int key=returnInt();//ɨ�����������ֵ
			 int i=findKey(key);//���ò��Һ��������ز��ҵ�������ֵ
			 if(i>=0)//�ж�ֵ�Ƿ����
			 {
				 System.out.println("ѧ�ţ�"+id[i]+"\t\t"+"������"+name[i]+"\t\t"+ "�ɼ���"+ score[i]);  //�����Ϣ
			 }else
			 {
				 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");//���û�ҵ�����ʾδ�ҵ�
			 }
			 choose();
		 }
		 public static void searchName()
		 {
			 System.out.println("������ѧ��������");
			 String key=returnString();//ɨ�����������ֵ
			 int flag=findName(key);
			 if(flag==-1)
			 {
				 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");//���û�ҵ�����ʾδ�ҵ� 
			 }else
			 {
				 int [] x=array(flag,digit(flag));
				 for(int y=x.length-2;y>=0;y--)
				 {
				     System.out.println("ѧ�ţ�"+id[x[y]]+"\t\t"+"������"+name[x[y]]+"\t\t"+ "�ɼ���"+ score[x[y]]);//��ӡ
				 }
			 }
			 choose();
		 }
		 public static void searchDown()
		 {
			 int [] idSort=copyInt();//���ú�������������
			 String [] nameSort=copyString();//���ú�������������
			 double [] scoreSort=copyDouble();//���������飬����󲻸ı�ԭ�����ݴ洢
			 sort(idSort,nameSort,scoreSort);//����ð��������
			 for(int i=0;i<idSort.length;i++)//������ӡ���
			 {
				 System.out.println("ѧ�ţ�"+idSort[i]+"\t\t"+"������"+nameSort[i]+"\t\t"+ "�ɼ���"+ scoreSort[i]);//��ӡ
			 }
			 choose();
		 }
		 public static int findKey(int key)//����ѭ����id���Һ���
		 {
			 for(int i=0;i<index;i++)//����������Ϣ�������в���
			 {
				 if(id[i]==key)//�ж��Ƿ����
					 return i;//���ҵ��򷵻�����ֵ
			 }
			 return -1;//���Ҳ����򷵻�-1
		 }
		 public static int findName(String key)//����ѭ�����������Һ���
		 {
			 int b=0,encryption=1;
			 for(int i=0;i<index;i++)//����������Ϣ�������в���
			 {
				 if(key.equals(name[i]))//�ж��ַ����Ƿ����
				 {
					 encryption=i+encryption*10;
					 b++;
				 }
				 }
			if(b!=0)
			{
				return encryption;
			}else
			    return -1;
		 }
			public static int digit(int x)//digit���������ܻ�ȡ���֣���������λ��
			{
				int n=0;
				while(x!=0)
				{
					n++;
					x=x/10;
				}
				return n;
			}
			public static int[] array(int num,int length)//array������������ת��Ϊ���飬����������
			{
				int[] array=new int[length];
				for(int a=0;a<length;a++)
				{
					array[a]=num%10;
					num/=10;
				}
				return array;
			}
		 public static void sort(int [] array1,String [] array2,double [] array3)//sort�������������ð������
			{
				for(int i=0;i<index-1;i++)
					for(int j=0;j<index-1-i;j++)
				{
					if(array3[j]<array3[j+1])
					{
						transoposition(array1,array2,array3,j);
					}
				}
			}
		 public static void transoposition(int [] array1,String [] array2,double [] array3,int i)//��λ����
		 {
			    int temp1=array1[i];
			    array1[i]=array1[i+1];
			    array1[i+1]=temp1;//ѧ�Ż�λ
				String temp2=array2[i];
				array2[i]=array2[i+1];
				array2[i+1]=temp2;//������λ
				double temp3=array3[i];
				array3[i]=array3[i+1];
				array3[i+1]=temp3;//������λ		
		 }
		 public static int returnInt()//���ڽ���������������
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//����input����ʹ��Scannerɨ�����������Ϣ
			 return input.nextInt();		//����������Ϣ 
		 }
		 public static String returnString()//���ڽ����ַ�����������
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//����input����ʹ��Scannerɨ�����������Ϣ
			 return input.next();		 //����������Ϣ 
		 }
		 public static Double returnDouble()
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//����input����ʹ��Scannerɨ�����������Ϣ
			 return input.nextDouble();		//����������Ϣ  
		 }
		 public static int [] copyInt()//����������
		 {
			 int [] array=new int [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=id[i];
					 }
					 return array;
		 }
		 public static String [] copyString()//����������
		 {
			 String [] array=new String [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=name[i];
					 }
					 return array;
		 }
		 public static double [] copyDouble()//����������
		 {
			 double [] array=new double [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=score[i];
					 }
					 return array;
		 }
}
