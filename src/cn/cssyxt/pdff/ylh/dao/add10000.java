package cn.cssyxt.pdff.ylh.dao;

import java.io.File;
import java.io.FileWriter;
/**
 * ����10000�����ݵ�f:/��Ʒ��.txt
 * @author Administrator
 *
 */
public class add10000 {
	private static String firstName="ƻ���㽶���Ӿ�Ӣ���������Ⱦ����������Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β���֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ����Ůʿ�Ӵ���������ɱ��֧��ϸ���ô��ʲô�ǻ���ĬĬ�ؽ�";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    public static boolean pd(String a,String b) {
    	int i;
    	for (i = 0; i < a.length(); i++) {
			if(b.contains(a.charAt(i)+"")){//�ж��Ƿ����
				return true;
			}
		}
		return false;
		
    }
    //���������Ʒ���
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("2019401");//ѧ��ǰ7λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,999)));//���ȡ��3λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "00");//�����1λ����ǰ������2��0
    		xh=xh.append(xh1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "0");//�����2λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //���������Ʒ�� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ��ͷ�ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
           
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    
  
    public static void main(String[] args) {
    	for(int i=1;i<=10000;i++) {
    		String zl;
				String spm=getChineseName();//�����ȡ��Ʒ��
				int sl=getNum(10,1000);
				int money=getNum(1, 200);//�����ȡ�۸�
	    		if(getNum(0,5)==0) {
	    			zl="�ֻ�";
	    		}
	    		else if(getNum(0,5)==1){
	    			zl="�߲�";
	    		}
	    		else if(getNum(0,5)==2){
	    			zl="ˮ��";
	    		}
	    		else if(getNum(0,5)==3){
	    			zl="����";
	    		}
	    		else if(getNum(0,5)==4){
	    			zl="�ҵ�";
	    		}
	    		else {
	    			zl="��ʳ";
	    		}
	    		File file=new File("f:/��Ʒ��.txt");
	    		try(FileWriter fw=new FileWriter(file,true)){//�����ַ������
	    		    //���û��������Ϣд��ָ���ļ�
	    		   fw.write(i+"\t"+zl+"\t"+spm+"\t"+sl+"\t"+money+"\r\n");
	    		}catch(Exception e1) {e1.printStackTrace();}
				
			
		}
    	
    	
    }
}
