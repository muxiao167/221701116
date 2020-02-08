/**
 * InfectStatistic
 * TODO
 *
 * @author 221701116
 * @version 1.0
 * @since 2020-02-06
 */

class InfectStatistic {
	
    public static void main(String[] args) {
    	if (args.length == 0) {  
            System.out.println("�����и�ʽ����");  
            return;
        }
    	CmdArgs cmdargs = new CmdArgs(args);
    	boolean b = cmdargs.extractCmd();
    	if(b == false) {
    		System.out.println("�����и�ʽ����");
    		return;
    	}
    	
    }
}

/*
 * ���������в���
 */
class CmdArgs{
	//int i; //��args���±�λ�ö���Ϊȫ�ֱ��������ڴ���
	String[] args; //���洫���������
	
	String log_path; //��־�ļ�λ��
	String out_path; //����ļ�λ��
	String date; //ָ������
	
	/*
	 * ָ������(��˳��ֱ�Ϊip,sp,cure,dead)
	 * ����ֵΪ1ʱ��ʾ��Ҫ�г���Ϊ0ʱ�����г�
	 */
	int[] type = {1,1,1,1};
	
	/*
	 * ָ��ʡ��(��ʡ���������򣨵�һλΪȫ����)
	 */
	int province[] = new int[35];
	
	CmdArgs(String[] args_str){
		args = args_str;
	}
	
	/*
	 * ��ȡ�������еĲ���
	 * @return
	 */
	public boolean extractCmd() {
		if(!args[0].equals("list")) //�ж������ʽ��ͷ�Ƿ���ȷ
			return false;
		
		int i;
		
		for(i = 1; i < args.length; i++) {
			if(args[i].equals("-log"))
				i = getLogPath(++i);
			else if(args[i].equals("-out"))
				i= getOutPath(++i);
			else if(args[i].equals("-date")) 
				i= getDate(++i);
			else if(args[i].equals("-type"))
				i = getType(++i); 
			else if(args[i].equals("-province"))
				i = getProvince(++i);
			
			if(i == -1) //˵�����������з��������г���
				return false;
		}
		return true;
	}
	
	/*
	 * �õ���־�ļ�λ��
	 * @param i
	 * @return
	 */
	public int getLogPath(int i) {
		if(i < args.length)
		{
			log_path = args[i];
		}
		else
			return -1;
		return i;
	}
	
	/*
	 * �õ���־�ļ�λ��
	 * @param i
	 * @return
	 */
	public int getOutPath(int i) {
		if(i < args.length)
		{
			out_path = args[i];
		}
		else
			return -1;
		return i;
	}
	
	/*
	 * �õ�ָ������
	 * @param i
	 * @return
	 */
	public int getDate(int i) {
		if(i < args.length)
		{
			date = args[i];
		}
		else
			return -1;
		return i;
	}
	
	/*
	 * �õ�ָ������(type���������ж��)
	 * @param i
	 * @return int
	 */
	public int getType(int i) {
		int j = i, m = i;

		if(i < args.length)
		{
			for(j = 0; j < 4; j++)
				type[j] = 0;
			while(i<args.length) {
				switch(args[i]) {
					case "ip" :
						type[0] = 1;
						j = i++;
						break;
					case "sp":
						type[1] = 1;
						j = i++;
						break;
					case "cure":
						type[2] = 1;
						j = i++;
						break;
					case "dead":
						type[3] = 1;
						j = i++;
						break;
					default:
						break;
				}
			}
		}
		if(m == i) //˵��-type������ȷ����
			return -1;
		return (j - 1); //��������Ϊ-type�Ĳ�������Խ��
	}
	
	/*
	 * �õ�ָ��ʡ��(province���������ж��)
	 * @param i
	 * @return int
	 */
	public int getProvince(int i) {
		int j, m = i;

		if(i < args.length)
		{
			//ָ��ʡ��
		}
		if(m == i) //˵��-province������ȷ����
			return -1;
		return i;
	}
	
}