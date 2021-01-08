package cn.cssyxt.pdff.ylh.dao;

import java.io.File;
import java.io.FileWriter;
/**
 * 产生10000条数据到f:/商品表.txt
 * @author Administrator
 *
 */
public class add10000 {
	private static String firstName="苹果香蕉梨子娟英华慧巧美娜静淑惠珠翠雅文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺数次女士接触地面可免费杀开支明细加拿大叫什么是积分默默地将";
	//定义女生的名
	private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	//定义男生的名
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    public static boolean pd(String a,String b) {
    	int i;
    	for (i = 0; i < a.length(); i++) {
			if(b.contains(a.charAt(i)+"")){//判断是否相等
				return true;
			}
		}
		return false;
		
    }
    //随机返回商品编号
    public static StringBuilder getStuno() {//不使用String，因为需要大量拼接字符串
    	StringBuilder xh=new StringBuilder("2019401");//学号前7位相同
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,999)));//随机取后3位
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "00");//如果是1位数，前面增加2个0
    		xh=xh.append(xh1);//前6位与后3位拼接成学号
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "0");//如果是2位数，前面增加1个0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //随机返回商品名 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//随机取开头字符串中的任意位置
        String first=firstName.substring(index, index+1);//获取该位置的姓氏
        int sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生字符串的长度
        if(sex==0){//如果随机获取为0，则名字改为女生
            str=girl;
            length=girl.length();
           
        }
        index=getNum(0,length-1);//随机获取名字的位置
        String second=str.substring(index, index+1);//获取该位置中的名字
        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
        String third="";//默认没有第三个字
        if(hasThird==1){//如果随机获取为1，则有第三个字
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//返回姓名
    }
    
  
    public static void main(String[] args) {
    	for(int i=1;i<=10000;i++) {
    		String zl;
				String spm=getChineseName();//随机获取商品名
				int sl=getNum(10,1000);
				int money=getNum(1, 200);//随机获取价格
	    		if(getNum(0,5)==0) {
	    			zl="手机";
	    		}
	    		else if(getNum(0,5)==1){
	    			zl="蔬菜";
	    		}
	    		else if(getNum(0,5)==2){
	    			zl="水果";
	    		}
	    		else if(getNum(0,5)==3){
	    			zl="饮料";
	    		}
	    		else if(getNum(0,5)==4){
	    			zl="家电";
	    		}
	    		else {
	    			zl="零食";
	    		}
	    		File file=new File("f:/商品表.txt");
	    		try(FileWriter fw=new FileWriter(file,true)){//创建字符输出流
	    		    //将用户输入的信息写入指定文件
	    		   fw.write(i+"\t"+zl+"\t"+spm+"\t"+sl+"\t"+money+"\r\n");
	    		}catch(Exception e1) {e1.printStackTrace();}
				
			
		}
    	
    	
    }
}
