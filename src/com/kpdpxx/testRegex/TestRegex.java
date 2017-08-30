package com.kpdpxx.testRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestRegex {

	public static void main(String[] args) {
		
		String jsonStr="{\"Trade\":[{\"AssigneeList\":\"\",\"AssigneeListCount\":0,\"TradeResCode\":\"02\",\"TradeResDesc\":\"其他原因（统一认证登录失败）\"},{\"AssigneeList\":\"\",\"AssigneeListCount\":1,\"TradeResCode\":\"04\",\"TradeResDesc\":\"1其他原因（统一认证登录失败）\"}]}";
		JSONObject jsonObj=JSONObject.parseObject(jsonStr);
		String path="Trade->TradeResCode";
		String[] paths=path.split("->");
		replaceJson(jsonObj, paths, 0);
		System.out.println("最终JSON："+jsonObj.toString());
		
		String jsonStr2="{\"Trade1\":{\"AssigneeList\":\"\",\"AssigneeListCount\":0,\"xxxxx\":{\"yyyy\":\"OMG\"},\"TradeResDesc\":\"其他原因（统一认证登录失败）\"}}";
		JSONObject jsonObj2=JSONObject.parseObject(jsonStr2);
		String path2="Trade1->xxxxx->yyyy";
		String[] paths2=path2.split("->");
		replaceJson(jsonObj2, paths2, 0);
		System.out.println("最终JSON："+jsonObj2.toString());
		
		
	}

	public static void replaceJson(Object replaceNodeParent, String[] paths,int pathFlag) {
		String parentNode=paths[pathFlag];
		int newFlag=0;
		if(replaceNodeParent instanceof JSONObject){
			JSONObject  newJSONObject=(JSONObject)replaceNodeParent;
			Object newJSONObject1=newJSONObject.get(parentNode);
			if(pathFlag==paths.length-1){
				//表示已经获取到需要替换的节点前
				String oldVal=newJSONObject.getString(paths[paths.length-1]);
				System.out.println("oldValJSONObject:"+newJSONObject.toJSONString());
				String newVal="newVal";
				newJSONObject.put(paths[paths.length-1],newVal);
				System.out.println("newJSONObject:"+newJSONObject.toJSONString());
			}else{
//				pathFlag++;
				replaceJson(newJSONObject1,paths,++pathFlag);
			}
		}else if(replaceNodeParent  instanceof JSONArray){
			JSONArray  newJSONArray=(JSONArray)replaceNodeParent;
			for(int i=0;i<newJSONArray.size();i++){
				replaceJson(newJSONArray.get(i),paths,pathFlag);
			}
		}
	}

	public static String findMatchGroup(String str, String regex, int group){
		Matcher m = Pattern.compile(regex, Pattern.DOTALL).matcher(str);
		String result = null;
		if (m.find()) {
			result = m.group(group);
		}
		return result;
	}
	
	public static int findMatchGroup(String str, String regex){
		Matcher m = Pattern.compile(regex, Pattern.DOTALL).matcher(str);
		int result = 0;
		if (m.find()) {
			result = m.groupCount();
		}
		return result;
	}
}
