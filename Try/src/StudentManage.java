import java.util.Scanner;//������
public class StudentManage {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("��ʼ���༶ѧ��������������ѧ��������");
		int num=data.nextInt();//��������
		int [] id=new int [num];//��ʼ��id������ѧ��ѧ��
		String [] name=new String [num];//��ʼ��name������ѧ������
		double [] score=new double[num];//��ʼ��score������ѧ���ɼ�
		int index=0;//��ȡ��������
		function(id,name,score,index);//���ù��ܺ���
		data.close();
	}
	public static void function(int [] id,String [] name,double [] score,int index)//���ܺ���
	{
		Scanner dataFun=new Scanner(System.in);//����һ��Scanner��ʵ��
		 jieMian();//��ʾ����
         int num1=dataFun.nextInt();//ɨ������ֵ
         if(num1==1)
         {
        	 add(id,name,score,index); //numΪ1ʱ�������ѧ����Ϣ����
         }else if(num1==2)
         {
        	 revised(id,name,score,index);//numΪ2ʱ�����޸Ĺ���
        	 function(id,name,score,index);//����
         }else if(num1==3)
         {
        	 del(id,name,score,index);//numΪ3ʱ����ɾ������
        	 function(id,name,score,index);//����
         }else if(num1==4)
         {
        	 search(id,name,score,index);//numΪ4ʱ���ò��ҹ���
        	 function(id,name,score,index);//����
         }else
         {
        	 System.out.println("������Ϣ����");//������������ֵ��ʾ
        	 function(id,name,score,index);//����
         }
         dataFun.close();
	}
	public static void jieMian()//���湦�ܲ���
	{
		String [] array={"\n"+"\n"+
				                  "******************************ѧ������ϵͳ******************************",
				                  "1�����ѧ����Ϣ",
				                  "2���޸�ѧ����Ϣ",
				                  "3��ɾ��ѧ����Ϣ",
				                  "4����ѯѧ����Ϣ",
				                  "************************************************************************"};//�����������
		for(int i=0;i<array.length;i++)//�������
		{
			System.out.println(array[i]);//��ӡ
		}	
	}
	//��ӹ��ܲ��֣�����������������int����ѧ�š�String���͵�������double���ͳɼ���¼������
		public static void add(int [] id,String [] name,double [] score,int index)//�����Ϣ���ܺ���
		{
			Scanner dataIn=new Scanner(System.in);//����һ��Scanner��ʵ��
			System.out.println("\n"+"\n"+"******************************���ѧ����Ϣ******************************");//��ӡ���
			System.out.print("������ѧ��ѧ�ţ�");//��ӡ���
			int idn=dataIn.nextInt();//ɨ�����������ֵ
	        id[index]=idn;//¼��ѧ����Ϣ��Ž�����
	        System.out.print("������ѧ��������");
			String ming=dataIn.next();//ɨ�����������ֵ
	        name[index]=ming;//¼��������Ϣ��Ž�����
	        System.out.print("������ѧ���ɼ���");//��ӡ���
			double scoreNum=dataIn.nextDouble();//ɨ�����������ֵ
	        score[index]=scoreNum;//¼�������Ϣ��Ž�����
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//�ж���Ϣ�Ƿ��������
	        {
	        	index++;//������һ
	        	System.out.println("ѧ����Ϣ������");
	        	System.out.println("************************************************************************");
	        	function(id,name,score,index);//���ù��ܺ���
	        }else
	        {
	        	id[index]=0;//���������͸����ݳ�ʼ��
	        	name[index]=null;//���������͸����ݳ�ʼ��
	        	score[index]=0.0;//���������͸����ݳ�ʼ��
	    		System.out.println("ѧ����Ϣ��Ӵ�������������");//��ӡ������Ϣ
	    		System.out.println("************************************************************************");
	        	function(id,name,score,index);//���ù��ܺ���
	        }
	        dataIn.close();
			}
		public static void revised(int [] id,String [] name,double [] score,int index)//��Ϣ�޸ĺ���
		{
			Scanner dataRev=new Scanner(System.in);//����һ��Scanner��ʵ��
			System.out.println("������ѧ���޸���Ϣ");
			int numRev=dataRev.nextInt();//ɨ�����������ֵ
			 for(int i=0;i<index;i++)//ѭ������
			 {
				 if(id[i]==numRev)//�ж�ֵ�Ƿ����
				 {
					 System.out.print("�������޸�ѧ�ţ�");//��ӡ���
				     int idn=dataRev.nextInt();//ɨ�����������ֵ
				     id[i]=idn;//¼��ѧ����Ϣ��Ž�����
				     System.out.print("�������޸�������");
					 String ming=dataRev.next();//ɨ�����������ֵ
				     name[i]=ming;//¼��������Ϣ��Ž�����
				     System.out.print("�������޸ĳɼ���");//��ӡ���
					 double scoreNum=dataRev.nextDouble();//ɨ�����������ֵ
				     score[i]=scoreNum;//¼�������Ϣ��Ž�����
				     if(id[i]>0&&name[i]!=null&&score[i]>=0)//�ж���Ϣ�Ƿ��������
				    {
				        	System.out.println("ѧ����Ϣ�޸����");
				        	function(id,name,score,index);//���ù��ܺ���
				        }else
				        {
				        	id[i]=0;//���������͸����ݳ�ʼ��
				        	name[i]=null;//���������͸����ݳ�ʼ��
				        	score[i]=0.0;//���������͸����ݳ�ʼ��
				    		System.out.println("ѧ����Ϣ�޸Ĵ�������������");//��ӡ������Ϣ
				        	function(id,name,score,index);//���ù��ܺ���
				        }
				     }else
				     {
					 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");  //���û�ҵ�����ʾδ�ҵ�
					 function(id,name,score,index);//���ù��ܺ���
					 }
			 }	
			 dataRev.close();
		}
		public static void del(int [] id,String [] name,double [] score,int index)//��Ϣɾ������
		{
			Scanner dataDel=new Scanner(System.in);//����һ��Scanner��ʵ��
			System.out.println("������ѧ��ɾ����Ϣ");
			int numDel=dataDel.nextInt();//ɨ�����������ֵ
			 for(int i=0;i<index;i++)//ѭ������
			 {
				 if(id[i]==numDel)//�ж�ֵ�Ƿ����
				 {
					 id[i]=0;//���ݳ�ʼ��
			         name[i]=null;//���ݳ�ʼ��
			         score[i]=0.0;//���ݳ�ʼ��
			    	 System.out.println("ѧ����Ϣ��ɾ��");//��ӡ��Ϣ
			    	 function(id,name,score,index);//���ù��ܺ���
				 }else
				 {
					 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");  //���û�ҵ�����ʾδ�ҵ�
					 function(id,name,score,index);//���ù��ܺ���
				 }
				 }
			 dataDel.close();
		}
		//��Ӽ������ܣ����󣬸���¼����ֵ���жϲ�ѯ��ʽ���������Ӧ��Ϣ
		//�޷�����ֵ
		 public static void search(int [] id,String [] name,double [] score,int index)//��Ϣ��������
		 {
			 Scanner dataSch=new Scanner(System.in);//����һ��Scanner��ʵ��
			 System.out.println("\n"+"\n"+"******************************��ѯѧ����Ϣ******************************"+"\n"+
		 "1����ѯȫ��ѧ����Ϣ"+"\n"+"2����ѧ�Ų�ѯѧ����Ϣ"+"\n"+"3����ѧ���ɼ���ʾѧ����Ϣ������"+"\n"+
		                                     "************************************************************************");//�����Ϣ
			 System.out.println("��ѡ���ѯ��ʽ");//��ӡ�����Ϣ
			 int num=dataSch.nextInt();//ɨ�����������ֵ
			 if(num==1)
			 {
				 for(int i=0;i<index;i++)
				 {
					 System.out.println("ѧ�ţ�"+id[i]+"\t"+"������"+name[i]+"\t"+ "�ɼ���"+ score[i]);
				 }		 //����ֵΪ1ʱѭ�����ѧ����Ϣ
				 function(id,name,score,index);//���ù��ܺ���
			 }else  if(num==2)
			 {
				 System.out.println("������ѧ��ѧ�ţ�");
				 int key=dataSch.nextInt();//ɨ�����������ֵ
				 if(key>0)//�ж�����ֵ�Ƿ����Ҫ��
				 {
					 for(int i=0;i<index;i++)//ѭ������
					 {
						 if(id[i]==key)//�ж�ֵ�Ƿ����
						 {
							System.out.println("ѧ�ţ�"+id[i]+"\t"+"������"+name[i]+"\t"+ "�ɼ���"+ score[i]);  //�����Ϣ
							function(id,name,score,index);//���ù��ܺ���
						 }else
						 {
							 System.out.println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");  //���û�ҵ�����ʾδ�ҵ�
							 search(id,name,score,index);//������������
						 }
					 }	
				 }else 
				 {
					 System.out.println("���������˶Ժ�����");//�ж�����ֵΪ��ֵʱ��ʾ�������
					 function(id,name,score,index);//���ù��ܺ���
				 }
			 }else  if(num==3)//�ж�numֵΪ3ʱ������
			 {
				 int [] idSort=copyid(id,index);//���ú�������������
				 String [] nameSort=copyname(name,index);//���ú�������������
				 double [] scoreSort=copyscore(score,index);//���������飬����󲻸ı�ԭ�����ݴ洢
				 sort(idSort,nameSort,scoreSort,index);//����ð��������
				 for(int i=0;i<idSort.length;i++)//������ӡ���
				 {
					 System.out.println("ѧ�ţ�"+idSort[i]+"\t"+"������"+nameSort[i]+"\t"+ "�ɼ���"+ scoreSort[i]);//��ӡ
				 }
				 function(id,name,score,index);//���ù��ܺ���
			 }
			 dataSch.close();
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
