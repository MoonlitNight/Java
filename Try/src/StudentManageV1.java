
public class StudentManageV1 {
	public static void main(String[] args) 
	{
		Initialization();
	}
	public static void Initialization()//��ʼ������
	{
		System.out.println("��ʼ������ϵͳ�洢�����������벢���س�ȷ�ϣ�");
		int num=returnInt();//��������
		int [] id=new int [num];//��ʼ��id������ѧ��ѧ��
		String [] name=new String [num];//��ʼ��name������ѧ������
		double [] score=new double[num];//��ʼ��score������ѧ���ɼ�
		int index=0;//��ȡ��������
		choose(id,name,score,index);//���ù��ܺ���
	}
	public static void choose(int [] id,String [] name,double [] score,int index)//ѡ���ܺ���
	{
		ui();//��ʾ����
		int num=returnInt();//ɨ������ֵ
		switch(num)
		{
		case 1:add(id,name,score,index);break;//����ֵΪ1ʱ�������ѧ����Ϣ����
		case 2:revised(id,name,score,index);break;//����ֵΪ2ʱ�����޸Ĺ���
		case 3:del(id,name,score,index);break;//����ֵΪ3ʱ����ɾ������
		case 4:search(id,name,score,index);break;//����ֵΪ4ʱ���ü�������
		case 5:System.exit(0);break;//�����˳�����
		default:System.out.println("������Ϣ������������");
		choose(id,name,score,index);//����ֵ���󣬷��ع���ѡ�����
		}
	}
	public static void ui()//���湦�ܲ���
	{
		String [] array={"\n"+"\n"+
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
		public static void add(int [] id,String [] name,double [] score,int index)//�����Ϣ���ܺ���
		{
			System.out.println("\n"+"\n"+"******************************���ѧ����Ϣ******************************");//��ӡ���
			System.out.print("������ѧ��ѧ�ţ�");//��ӡ���
			id[index]=returnInt();//¼��ѧ����Ϣ��Ž�����
	        System.out.print("������ѧ��������");
	        name[index]=returnString();//¼��������Ϣ��Ž�����
	        System.out.print("������ѧ���ɼ���");//��ӡ���
	        score[index]=returnDouble();//¼�������Ϣ��Ž�����
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//�ж���Ϣ�Ƿ��������
	        {
	        	index++;//������һ
	        	System.out.println("ѧ����Ϣ������");
	        	System.out.println("************************************************************************");

	        }else
	        {
	        	id[index]=0;//���������͸����ݳ�ʼ��
	        	name[index]=null;//���������͸����ݳ�ʼ��
	        	score[index]=0.0;//���������͸����ݳ�ʼ��
	    		System.out.println("ѧ����Ϣ��Ӵ�������������");//��ӡ������Ϣ
	    		System.out.println("************************************************************************");
	        }
	        choose(id,name,score,index);//����ѡ���ܺ���
	        }
		public static void revised(int [] id,String [] name,double [] score,int index)//��Ϣ�޸ĺ���
		{
			if(index!=0)//�ж�index��Ϊ0ʱ�ſ����޸���Ϣ
			{
			System.out.println("������ѧ���޸���Ϣ");
			int date=returnInt();//ɨ�����������ֵ
			int i=findKey(id,index,date);//���ò��Һ��������ز��ҵ�������ֵ
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
						id[i]=0;//���������͸����ݳ�ʼ��
						name[i]=null;//���������͸����ݳ�ʼ��
						score[i]=0.0;//���������͸����ݳ�ʼ��
						System.out.println("ѧ����Ϣ�޸Ĵ�������������");//��ӡ������Ϣ
					}
				}else 
				{
					System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");  //���û�ҵ�����ʾδ�ҵ� 
				}
			}else
			{
				System.out.println("����ѧ����Ϣ������Ӻ���ʹ�ñ�����");//�ж�indexΪ0ʱ��ʾ��ѧ����Ϣ
			}
			choose(id,name,score,index);//����ѡ���ܺ���
		}
		public static void del(int [] id,String [] name,double [] score,int index)//��Ϣɾ������
		{
			if(index!=0)//�ж�index��Ϊ0ʱ�ſ���ɾ����Ϣ
			{
			System.out.println("������ѧ��ɾ����Ϣ");
			int data=returnInt();//ɨ�����������ֵ
			int i=findKey(id,index,data);//���ò��Һ��������ز��ҵ�������ֵ
			if(i>=0)//�ж�ֵ�Ƿ����
			{
				id[i]=0;//���ݳ�ʼ��
				name[i]=null;//���ݳ�ʼ��
				score[i]=0.0;//���ݳ�ʼ��
				System.out.println("ѧ����Ϣ��ɾ��");//��ӡ��Ϣ 
			}else
			{
				System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");//���û�ҵ�����ʾδ�ҵ�
			}
			}else
			{
				System.out.println("����ѧ����Ϣ������Ӻ���ʹ�ñ�����");//�ж�indexΪ0ʱ��ʾ��ѧ����Ϣ
			}
			choose(id,name,score,index);//����ѡ���ܺ���
		}
		//��Ӽ������ܣ����󣬸���¼����ֵ���жϲ�ѯ��ʽ���������Ӧ��Ϣ
		//�޷�����ֵ
		 public static void search(int [] id,String [] name,double [] score,int index)//��Ϣ��������
		 {
			 if(index!=0)//�ж�index��Ϊ0ʱ�ſ��Լ����鿴��Ϣ
			 {
			 System.out.println("\n"+"\n"+ "******************************��ѯѧ����Ϣ******************************"+
		                                              "\n"+"1����ѯȫ��ѧ����Ϣ"+
		                                              "\n"+"2����ѧ�Ų�ѯѧ����Ϣ"+
		                                              "\n"+"3����ѧ���ɼ���ʾѧ����Ϣ������"+
		                                              "\n"+"************************************************************************");//�����Ϣ
			 System.out.println("��ѡ���ѯ��ʽ");//��ӡ�����Ϣ
			 int data=returnInt();//ɨ�����������ֵ
			 if(data==1)
			 {
				 for(int i=0;i<index;i++)
				 {
					 System.out.println("ѧ�ţ�"+id[i]+"\t"+"\t"+"������"+name[i]+"\t"+"\t"+ "�ɼ���"+ score[i]);
				 }		 //����ֵΪ1ʱѭ�����ѧ����Ϣ
			 }else  if(data==2)
			 {
				 System.out.println("������ѧ��ѧ�ţ�");
				 int key=returnInt();//ɨ�����������ֵ
				 int i=findKey(id,index,key);//���ò��Һ��������ز��ҵ�������ֵ
				 if(i>=0)//�ж�ֵ�Ƿ����
				 {
					 System.out.println("ѧ�ţ�"+id[i]+"\t"+"\t"+"������"+name[i]+"\t"+"\t"+ "�ɼ���"+ score[i]);  //�����Ϣ
				 }else
				 {
					 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");//���û�ҵ�����ʾδ�ҵ�
				 }
			 }else  if(data==3)//�ж�numֵΪ3ʱ������
			 {
				 int [] idSort=copyid(id,index);//���ú�������������
				 String [] nameSort=copyname(name,index);//���ú�������������
				 double [] scoreSort=copyscore(score,index);//���������飬����󲻸ı�ԭ�����ݴ洢
				 sort(idSort,nameSort,scoreSort,index);//����ð��������
				 for(int i=0;i<idSort.length;i++)//������ӡ���
				 {
					 System.out.println("ѧ�ţ�"+idSort[i]+"\t"+"\t"+"������"+nameSort[i]+"\t"+"\t"+ "�ɼ���"+ scoreSort[i]);//��ӡ
				 }
			 }
			 }else 
			 {
				 System.out.println("����ѧ����Ϣ������Ӻ���ʹ�ñ�����");//�ж�indexΪ0ʱ��ʾ��ѧ����Ϣ
			 }
			 choose(id,name,score,index);//����ѡ���ܺ���
		 }
		 public static int findKey(int [] array,int index,int key)//id����ѭ�����Һ���
		 {
			 for(int i=0;i<index;i++)//����������Ϣ�������в���
			 {
				 if(array[i]==key)//�ж��Ƿ����
					 return i;//���ҵ��򷵻�����ֵ
			 }
			 return -1;//���Ҳ����򷵻�-1
		 }
		 public static void sort(int [] id,String [] name,double [] score,int index)//sort�������������ð������
			{
				for(int i=0;i<index-1;i++)
					for(int j=0;j<index-1-i;j++)
				{
					if(score[j]<score[j+1])
					{
						double temp=score[j];
						score[j]=score[j+1];
						score[j+1]=temp;//������λ
						String temp1=name[j];
						name[j]=name[j+1];
						name[j+1]=temp1;//������λ
						int temp2=id[j];
						id[j]=id[j+1];
						id[j+1]=temp2;//ѧ�Ż�λ
					}
				}
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
		 public static int [] copyid(int [] array,int index)//����������
		 {
			 int [] array1=new int [index];
					 for(int i=0;i<index;i++)
					 {
						 array1[i]=array[i];
					 }
					 return array1;
		 }
		 public static String [] copyname(String [] array,int index)//����������
		 {
			 String [] array2=new String [index];
					 for(int i=0;i<index;i++)
					 {
						 array2[i]=array[i];
					 }
					 return array2;
		 }
		 public static double [] copyscore(double [] array,int index)//����������
		 {
			 double [] array3=new double [index];
					 for(int i=0;i<index;i++)
					 {
						 array3[i]=array[i];
					 }
					 return array3;
		 }
}
