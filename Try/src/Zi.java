public class Zi {
	public static void main(String[] args)
	{
		char zi='D';//¶¨ÒåÒ»¸ö×Ö·ûĞÍ±äÁ¿²¢¸³Öµ
		if(zi>='0'&zi<='9')//ÅĞ¶Ï¸Ã×Ö·ûÊÇ·ñÎªÊı×Ö×Ö·û
		{
			System.out.println(zi+"×Ö·ûÎªÊı×Ö");//´òÓ¡Êä³ö
		}else if(zi>='A'&zi<='Z')//ÅĞ¶Ï¸Ã×Ö·ûÊÇ·ñÎª´óĞ´Ó¢ÎÄ×Ö·û
		{
			System.out.println(zi+"×Ö·ûÎª´óĞ´Ó¢ÎÄ×ÖÄ¸");//´òÓ¡Êä³ö
		}else if(zi>='a'&zi<='z')//ÅĞ¶Ï¸Ã×Ö·ûÊÇ·ñÎªĞ¡Ğ´Ó¢ÎÄ×Ö·û
		{
			System.out.println(zi+"×Ö·ûÎªĞ¡Ğ´Ó¢ÎÄ×ÖÄ¸");//´òÓ¡Êä³ö
		}else
		    System.out.println(zi+"×Ö·ûÎªÌØÊâ×Ö·û");//´òÓ¡Êä³ö
	}
}
