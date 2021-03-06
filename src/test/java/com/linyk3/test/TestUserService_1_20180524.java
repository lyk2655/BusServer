package com.linyk3.test;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.linyk3.bean.UploadLocationRes;
import com.linyk3.service.BusService;
import com.linyk3.util.DateUtil;
import com.linyk3.util.MyHttpRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml","/spring-mybatis.xml"})
public class TestUserService_1_20180524 {

	Logger logger = Logger.getLogger(TestUserService_1_20180524.class);
   //private String ip = "localhost:8080/BocbusServer/";
  private String ip = "111.230.148.118:8080/BocbusServer/";
    
    @Autowired
    private BusService busService;

    
    @Test
    public void UpdateLocationController() throws Exception {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("113.864627         "); lats.add(" 22.5735            ");
    	lons.add("113.86459391276041 "); lats.add(" 22.574807942708333 ");
    	lons.add("113.86466498480902 "); lats.add(" 22.574735785590278 ");
    	lons.add("113.86473117404513 "); lats.add(" 22.57488986545139  ");
    	lons.add("113.86500244140625 "); lats.add(" 22.575023871527776 ");
    	lons.add("113.86510172526042 "); lats.add(" 22.575049913194444 ");
    	lons.add("113.86517605251736 "); lats.add(" 22.57504421657986  ");
    	lons.add("113.86524088541667 "); lats.add(" 22.57503824869792  ");
    	lons.add("113.8652671983507  "); lats.add(" 22.57513943142361  ");
    	lons.add("113.86562879774306 "); lats.add(" 22.57457817925347  ");
    	lons.add("113.8655859375     "); lats.add(" 22.5747314453125   ");
    	lons.add("113.86567220052083 "); lats.add(" 22.574800889756943 ");
    	lons.add("113.86569580078125 "); lats.add(" 22.574783528645835 ");
    	lons.add("113.8658531358507  "); lats.add(" 22.574860026041666 ");
    	lons.add("113.86592420789931 "); lats.add(" 22.574877387152778 ");
    	lons.add("113.86606065538194 "); lats.add(" 22.575117730034723 ");
    	lons.add("113.8661607530382  "); lats.add(" 22.57518771701389  ");
    	lons.add("113.86606716579861 "); lats.add(" 22.57529079861111  ");
    	lons.add("113.86615315755208 "); lats.add(" 22.57535183376736  ");
    	lons.add("113.86594699435764 "); lats.add(" 22.575689832899304 ");
    	lons.add("113.86601996527777 "); lats.add(" 22.575643988715278 ");
    	lons.add("113.86593370225694 "); lats.add(" 22.575604383680556 ");
    	lons.add("113.86652777777778 "); lats.add(" 22.575447862413196 ");
    	lons.add("113.86658799913195 "); lats.add(" 22.575215928819443 ");
    	lons.add("113.86620686848958 "); lats.add(" 22.575533582899304 ");
    	lons.add("113.86628770616319 "); lats.add(" 22.575494249131946 ");
    	lons.add("113.86633734809028 "); lats.add(" 22.575503743489584 ");
    	lons.add("113.86661539713542 "); lats.add(" 22.575428873697916 ");
    	lons.add("113.86660942925347 "); lats.add(" 22.575511881510415 ");
    	lons.add("113.86638970269097 "); lats.add(" 22.575604926215277 ");
    	lons.add("113.86627332899306 "); lats.add(" 22.575551215277777 ");
    	lons.add("113.86626736111111 "); lats.add(" 22.575533040364583 ");
    	lons.add("113.86637912326388 "); lats.add(" 22.57565402560764  ");
    	lons.add("113.86654188368055 "); lats.add(" 22.575704210069443 ");
    	lons.add("113.86651692708334 "); lats.add(" 22.57566351996528  ");
    	lons.add("113.8665660264757  "); lats.add(" 22.575726182725695 ");
    	lons.add("113.86666395399305 "); lats.add(" 22.575856119791666 ");
    	lons.add("113.86677083333333 "); lats.add(" 22.575924479166666 ");
    	lons.add("113.86684678819445 "); lats.add(" 22.575956217447917 ");
    	lons.add("113.86692437065972 "); lats.add(" 22.5760009765625   ");
    	lons.add("113.86701144748264 "); lats.add(" 22.575984700520834 ");
    	lons.add("113.86705078125    "); lats.add(" 22.576048719618054 ");
    	lons.add("113.86711724175348 "); lats.add(" 22.576120334201388 ");
    	lons.add("113.86716335720486 "); lats.add(" 22.576204427083333 ");
    	lons.add("113.86722873263889 "); lats.add(" 22.576312120225694 ");
    	lons.add("113.8672829861111  "); lats.add(" 22.576394585503472 ");
    	lons.add("113.86734619140626 "); lats.add(" 22.57643581814236  ");
    	lons.add("113.8674232313368  "); lats.add(" 22.57645779079861  ");
    	lons.add("113.86750868055556 "); lats.add(" 22.576486002604167 ");
    	lons.add("113.86755343967013 "); lats.add(" 22.576541341145834 ");
    	lons.add("113.86761094835069 "); lats.add(" 22.576587727864585 ");
    	lons.add("113.86763671875    "); lats.add(" 22.57667914496528  ");
    	lons.add("113.8676784939236  "); lats.add(" 22.576746961805554 ");
    	lons.add("113.86772569444445 "); lats.add(" 22.57680230034722  ");
    	lons.add("113.86777913411458 "); lats.add(" 22.576873101128474 ");
    	lons.add("113.86789794921874 "); lats.add(" 22.57688205295139  ");
    	lons.add("113.86792751736111 "); lats.add(" 22.576968044704863 ");
    	lons.add("113.86796576605903 "); lats.add(" 22.577021484375    ");
    	lons.add("113.86798773871527 "); lats.add(" 22.577049424913195 ");
    	lons.add("113.86804768880208 "); lats.add(" 22.57704644097222  ");
    	lons.add("113.86805881076388 "); lats.add(" 22.577063530815973 ");
    	lons.add("113.86807373046875 "); lats.add(" 22.57709418402778  ");
    	lons.add("113.8680775282118  "); lats.add(" 22.57711344401042  ");
    	lons.add("113.86809624565973 "); lats.add(" 22.577129720052085 ");
    	lons.add("113.86810302734375 "); lats.add(" 22.57714138454861  ");
    	lons.add("113.86811930338541 "); lats.add(" 22.57716281467014  ");
    	lons.add("113.86812662760417 "); lats.add(" 22.57718044704861  ");
    	lons.add("113.86815619574652 "); lats.add(" 22.577184787326388 ");
    	lons.add("113.86816786024306 "); lats.add(" 22.57718777126736  ");
    	lons.add("113.86816351996528 "); lats.add(" 22.57720431857639  ");
    	lons.add("113.86815945095486 "); lats.add(" 22.577199164496527 ");
    	lons.add("113.86816541883681 "); lats.add(" 22.577206759982637 ");
    	lons.add("113.8681751844618  "); lats.add(" 22.577213270399305 ");
    	lons.add("113.8681898328993  "); lats.add(" 22.577219780815973 ");
    	lons.add("113.8682142469618  "); lats.add(" 22.577226833767362 ");
    	lons.add("113.86823513454861 "); lats.add(" 22.577234157986112 ");
    	lons.add("113.8682603624132  "); lats.add(" 22.577241753472222 ");
    	lons.add("113.86828667534722 "); lats.add(" 22.577249348958333 ");
    	lons.add("113.86831624348959 "); lats.add(" 22.577252604166667 ");
    	lons.add("113.86835069444444 "); lats.add(" 22.57725043402778  ");
    	lons.add("113.86838650173611 "); lats.add(" 22.577250162760418 ");
    	lons.add("113.86843017578126 "); lats.add(" 22.577249891493057 ");
    	lons.add("113.86847276475694 "); lats.add(" 22.577249891493057 ");
    	lons.add("113.86851779513889 "); lats.add(" 22.577245822482638 ");
    	lons.add("113.8685560438368  "); lats.add(" 22.57723605685764  ");
    	lons.add("113.86859130859375 "); lats.add(" 22.5772216796875   ");
    	lons.add("113.86861707899305 "); lats.add(" 22.577191297743056 ");
    	lons.add("113.86865614149306 "); lats.add(" 22.577156846788196 ");
    	lons.add("113.86871120876737 "); lats.add(" 22.57712646484375  ");
    	lons.add("113.86873426649305 "); lats.add(" 22.577049696180556 ");
    	lons.add("113.86873969184028 "); lats.add(" 22.576953667534724 ");
    	lons.add("113.86880615234375 "); lats.add(" 22.576917046440972 ");
    	lons.add("113.86886420355903 "); lats.add(" 22.576864420572917 ");
    	lons.add("113.86891710069445 "); lats.add(" 22.576776801215278 ");
    	lons.add("113.86907606336806 "); lats.add(" 22.576671278211805 ");
    	lons.add("113.86914388020833 "); lats.add(" 22.57658501519097  ");
    	lons.add("113.86921142578124 "); lats.add(" 22.57651177300347  ");
    	lons.add("113.86929606119791 "); lats.add(" 22.576465657552085 ");
    	lons.add("113.86936414930555 "); lats.add(" 22.576394585503472 ");
    	lons.add("113.86944580078125 "); lats.add(" 22.57633273654514  ");
    	lons.add("113.86953043619792 "); lats.add(" 22.576273057725693 ");
    	lons.add("113.86958713107639 "); lats.add(" 22.57620578342014  ");
    	lons.add("113.86965223524305 "); lats.add(" 22.576163465711804 ");
    	lons.add("113.86970513237847 "); lats.add(" 22.57610107421875  ");
    	lons.add("113.86977077907986 "); lats.add(" 22.576033799913194 ");
    	lons.add("113.86981309678819 "); lats.add(" 22.57596652560764  ");
    	lons.add("113.86986870659722 "); lats.add(" 22.575909559461806 ");
    	lons.add("113.8699085828993  "); lats.add(" 22.57586697048611  ");
    	lons.add("113.86996744791666 "); lats.add(" 22.57581325954861  ");
    	lons.add("113.87002902560764 "); lats.add(" 22.57578857421875  ");
    	lons.add("113.87007432725694 "); lats.add(" 22.575735134548612 ");
    	lons.add("113.87011501736112 "); lats.add(" 22.5756787109375   ");
    	lons.add("113.87016194661459 "); lats.add(" 22.575648328993054 ");
    	lons.add("113.87014078776042 "); lats.add(" 22.575684950086806 ");
    	lons.add("113.87015109592014 "); lats.add(" 22.57569580078125  ");
    	lons.add("113.87020263671874 "); lats.add(" 22.575723198784722 ");
    	lons.add("113.87024576822917 "); lats.add(" 22.57565619574653  ");
    	lons.add("113.87020100911458 "); lats.add(" 22.575680881076387 ");
    	lons.add("113.87020968967013 "); lats.add(" 22.57568359375     ");
    	lons.add("113.87019178602431 "); lats.add(" 22.57568820529514  ");
    	lons.add("113.87017876519097 "); lats.add(" 22.57570583767361  ");
    	lons.add("113.87016927083333 "); lats.add(" 22.57571831597222  ");
    	lons.add("113.87016764322917 "); lats.add(" 22.575727810329862 ");
    	lons.add("113.87017632378472 "); lats.add(" 22.575726996527777 ");
    	lons.add("113.87018581814236 "); lats.add(" 22.575721028645834 ");
    	lons.add("113.87021131727431 "); lats.add(" 22.57571506076389  ");
    	lons.add("113.87024224175347 "); lats.add(" 22.575697157118057 ");
    	lons.add("113.87028537326388 "); lats.add(" 22.5756640625      ");
    	lons.add("113.87034071180555 "); lats.add(" 22.575601942274307 ");
    	lons.add("113.87036105685763 "); lats.add(" 22.575537651909723 ");
    	lons.add("113.87041612413195 "); lats.add(" 22.575499403211804 ");
    	lons.add("113.87047010633681 "); lats.add(" 22.575474989149306 ");
    	lons.add("113.87054036458333 "); lats.add(" 22.57544406467014  ");
    	lons.add("113.87055013020833 "); lats.add(" 22.575415581597223 ");
    	lons.add("113.87056287977431 "); lats.add(" 22.575387098524306 ");
    	lons.add("113.87059597439236 "); lats.add(" 22.575350748697918 ");
    	lons.add("113.87062337239583 "); lats.add(" 22.575335286458333 ");
    	lons.add("113.87059326171875 "); lats.add(" 22.575354817708334 ");
    	lons.add("113.87060139973958 "); lats.add(" 22.575372178819446 ");
    	lons.add("113.87061550564236 "); lats.add(" 22.575384657118054 ");
    	lons.add("113.87062717013889 "); lats.add(" 22.57539089626736  ");
    	lons.add("113.87062771267361 "); lats.add(" 22.57538818359375  ");
    	lons.add("113.87062255859375 "); lats.add(" 22.575375162760416 ");
    	lons.add("113.87060465494791 "); lats.add(" 22.57536648220486  ");
    	lons.add("113.87060302734375 "); lats.add(" 22.57536349826389  ");
    	lons.add("113.87060465494791 "); lats.add(" 22.575364583333332 ");
    	lons.add("113.87060845269097 "); lats.add(" 22.57537109375     ");
    	lons.add("113.87060709635416 "); lats.add(" 22.575368923611112 ");
    	lons.add("113.87061008029514 "); lats.add(" 22.57537163628472  ");
    	lons.add("113.87061252170139 "); lats.add(" 22.57537326388889  ");
    	lons.add("113.87061414930555 "); lats.add(" 22.575377332899304 ");
    	lons.add("113.8706103515625  "); lats.add(" 22.57537868923611  ");
    	lons.add("113.87061469184027 "); lats.add(" 22.575381130642363 ");
    	lons.add("113.870615234375   "); lats.add(" 22.575380045572917 ");
    	lons.add("113.87061442057292 "); lats.add(" 22.57537868923611  ");
    	lons.add("113.87061604817708 "); lats.add(" 22.575380316840278 ");
    	lons.add("113.87061794704861 "); lats.add(" 22.575381944444445 ");
    	lons.add("113.87062065972222 "); lats.add(" 22.575381673177084 ");
    	lons.add("113.8706374782986  "); lats.add(" 22.575386555989585 ");
    	lons.add("113.87064425998264 "); lats.add(" 22.57539252387153  ");
    	lons.add("113.87065049913194 "); lats.add(" 22.575393880208335 ");
    	lons.add("113.87064561631945 "); lats.add(" 22.575391438802082 ");
    	lons.add("113.87064154730903 "); lats.add(" 22.575386827256946 ");
    	lons.add("113.87064914279514 "); lats.add(" 22.575384928385418 ");
    	lons.add("113.87067084418403 "); lats.add(" 22.57538601345486  ");
    	lons.add("113.87068929036458 "); lats.add(" 22.57537841796875  ");
    	lons.add("113.87070339626736 "); lats.add(" 22.57536865234375  ");
    	lons.add("113.8707212999132  "); lats.add(" 22.575359700520835 ");
    	lons.add("113.8707310655382  "); lats.add(" 22.57534342447917  ");
    	lons.add("113.87073432074652 "); lats.add(" 22.575321180555555 ");
    	lons.add("113.87074679904514 "); lats.add(" 22.575306260850695 ");
    	lons.add("113.87076958550347 "); lats.add(" 22.575294596354166 ");
    	lons.add("113.87080457899306 "); lats.add(" 22.575277235243057 ");
    	lons.add("113.87083441840278 "); lats.add(" 22.575262044270833 ");
    	lons.add("113.87085639105902 "); lats.add(" 22.575250651041667 ");
    	lons.add("113.87087320963542 "); lats.add(" 22.57524115668403  ");
    	lons.add("113.87087239583333 "); lats.add(" 22.575238986545138 ");
    	lons.add("113.87087809244791 "); lats.add(" 22.575235460069443 ");
    	lons.add("113.87087565104167 "); lats.add(" 22.5752294921875   ");
    	lons.add("113.87087456597222 "); lats.add(" 22.575228135850693 ");
    	lons.add("113.87088975694445 "); lats.add(" 22.575224609375    ");
    	lons.add("113.87090603298611 "); lats.add(" 22.57522976345486  ");
    	lons.add("113.87092312282986 "); lats.add(" 22.575240342881944 ");
    	lons.add("113.87094618055555 "); lats.add(" 22.575240885416665 ");
    	lons.add("113.87097601996528 "); lats.add(" 22.57524115668403  ");
    	lons.add("113.87100857204861 "); lats.add(" 22.57521511501736  ");
    	lons.add("113.87103651258681 "); lats.add(" 22.575189887152778 ");
    	lons.add("113.87107177734374 "); lats.add(" 22.57516357421875  ");
    	lons.add("113.87115234375    "); lats.add(" 22.57512017144097  ");
    	lons.add("113.87121744791666 "); lats.add(" 22.575106065538193 ");
    	lons.add("113.87123942057292 "); lats.add(" 22.575036892361112 ");
    	lons.add("113.87130072699652 "); lats.add(" 22.574994032118056 ");
    	lons.add("113.87135470920138 "); lats.add(" 22.574957139756943 ");
    	lons.add("113.87145182291667 "); lats.add(" 22.57488552517361  ");
    	lons.add("113.87151828342014 "); lats.add(" 22.574859754774305 ");
    	lons.add("113.87155815972223 "); lats.add(" 22.574756673177085 ");
    	lons.add("113.8716370985243  "); lats.add(" 22.574698079427083 ");
    	lons.add("113.87175564236111 "); lats.add(" 22.574641655815974 ");
    	lons.add("113.87181179470485 "); lats.add(" 22.574574110243056 ");
    	lons.add("113.87190321180556 "); lats.add(" 22.574521484375    ");
    	lons.add("113.87197319878472 "); lats.add(" 22.574466417100695 ");
    	lons.add("113.87207139756944 "); lats.add(" 22.574400227864583 ");
    	lons.add("113.87217176649305 "); lats.add(" 22.574344618055555 ");
    	lons.add("113.87223253038195 "); lats.add(" 22.574286295572918 ");
    	lons.add("113.87234130859375 "); lats.add(" 22.57423312717014  ");
    	lons.add("113.87246392144097 "); lats.add(" 22.574165852864585 ");
    	lons.add("113.87250596788195 "); lats.add(" 22.57401665581597  ");
    	lons.add("113.87260904947917 "); lats.add(" 22.573936631944445 ");
    	lons.add("113.87273166232639 "); lats.add(" 22.573860677083335 ");
    	lons.add("113.87285753038195 "); lats.add(" 22.573782552083333 ");
    	lons.add("113.87296495225695 "); lats.add(" 22.57371826171875  ");
    	lons.add("113.8731654188368  "); lats.add(" 22.5735205078125   ");
    	lons.add("113.87328640407986 "); lats.add(" 22.57344021267361  ");
    	lons.add("113.87339762369791 "); lats.add(" 22.573368055555555 ");
    	lons.add("113.87352728949652 "); lats.add(" 22.573289930555557 ");
    	lons.add("113.87366509331598 "); lats.add(" 22.57321614583333  ");
    	lons.add("113.87376220703125 "); lats.add(" 22.573110080295137 ");
    	lons.add("113.87388617621528 "); lats.add(" 22.57303168402778  ");
    	lons.add("113.87399224175347 "); lats.add(" 22.572947048611113 ");
    	lons.add("113.87408962673611 "); lats.add(" 22.57287679036458  ");
    	lons.add("113.87419704861111 "); lats.add(" 22.572837999131945 ");
    	lons.add("113.87424913194444 "); lats.add(" 22.57279052734375  ");
    	lons.add("113.87429714626737 "); lats.add(" 22.572705891927082 ");
    	lons.add("113.87435574001736 "); lats.add(" 22.57267279730903  ");
    	lons.add("113.87440538194444 "); lats.add(" 22.572623155381944 ");
    	lons.add("113.87443901909722 "); lats.add(" 22.572593858506945 ");
    	lons.add("113.87447482638889 "); lats.add(" 22.57256293402778  ");
    	lons.add("113.8745179578993  "); lats.add(" 22.57252983940972  ");
    	lons.add("113.87455403645833 "); lats.add(" 22.57251220703125  ");
    	lons.add("113.87462429470486 "); lats.add(" 22.57247585720486  ");
    	lons.add("113.87462049696181 "); lats.add(" 22.572457682291667 ");
    	lons.add("113.8746603732639  "); lats.add(" 22.572425401475694 ");
    	lons.add("113.87470893012153 "); lats.add(" 22.572400987413193 ");
    	lons.add("113.87478461371528 "); lats.add(" 22.57235297309028  ");
    	lons.add("113.87481906467013 "); lats.add(" 22.572342122395835 ");
    	lons.add("113.87484347873264 "); lats.add(" 22.57230224609375  ");
    	lons.add("113.87491129557291 "); lats.add(" 22.572262098524305 ");
    	lons.add("113.87495768229167 "); lats.add(" 22.572215440538194 ");
    	lons.add("113.87499457465277 "); lats.add(" 22.572198350694446 ");
    	lons.add("113.87502549913195 "); lats.add(" 22.57217719184028  ");
    	lons.add("113.8750634765625  "); lats.add(" 22.572154134114584 ");
    	lons.add("113.87508002387153 "); lats.add(" 22.57213161892361  ");
    	lons.add("113.87512613932292 "); lats.add(" 22.572086046006945 ");
    	lons.add("113.87516194661458 "); lats.add(" 22.57204047309028  ");
    	lons.add("113.8752086046007  "); lats.add(" 22.57200954861111  ");
    	lons.add("113.8752476671007  "); lats.add(" 22.57199001736111  ");
    	lons.add("113.87526611328126 "); lats.add(" 22.57197998046875  ");
    	lons.add("113.87530300564237 "); lats.add(" 22.571957194010416 ");
    	lons.add("113.87533284505209 "); lats.add(" 22.571931694878472 ");
    	lons.add("113.8753306749132  "); lats.add(" 22.571925184461804 ");
    	lons.add("113.87533230251736 "); lats.add(" 22.571920301649307 ");
    	lons.add("113.87532986111111 "); lats.add(" 22.571920844184028 ");
    	lons.add("113.87532877604167 "); lats.add(" 22.571920844184028 ");
    	lons.add("113.87532606336805 "); lats.add(" 22.57192545572917  ");
    	lons.add("113.87532552083333 "); lats.add(" 22.571929524739584 ");
    	lons.add("113.87532524956598 "); lats.add(" 22.571929253472224 ");
    	lons.add("113.8753271484375  "); lats.add(" 22.571925184461804 ");
    	lons.add("113.87533094618055 "); lats.add(" 22.571923014322916 ");
    	lons.add("113.87534098307292 "); lats.add(" 22.571917588975694 ");
    	lons.add("113.87535047743056 "); lats.add(" 22.571909993489584 ");
    	lons.add("113.87536566840278 "); lats.add(" 22.571903483072916 ");
    	lons.add("113.8753843858507  "); lats.add(" 22.571892903645832 ");
    	lons.add("113.87541015625    "); lats.add(" 22.571878526475693 ");
    	lons.add("113.87543565538195 "); lats.add(" 22.57186279296875  ");
    	lons.add("113.8754616970486  "); lats.add(" 22.571846516927085 ");
    	lons.add("113.87550184461806 "); lats.add(" 22.571815592447916 ");
    	lons.add("113.87554850260416 "); lats.add(" 22.571785481770835 ");
    	lons.add("113.87560872395834 "); lats.add(" 22.571751844618056 ");
    	lons.add("113.87564480251736 "); lats.add(" 22.571726345486113 ");
    	lons.add("113.87567898220486 "); lats.add(" 22.571697591145835 ");
    	lons.add("113.87571967230903 "); lats.add(" 22.57167236328125  ");
    	lons.add("113.87577690972222 "); lats.add(" 22.571624620225695 ");
    	lons.add("113.87583414713542 "); lats.add(" 22.571571451822916 ");
    	lons.add("113.87591796875    "); lats.add(" 22.571500651041667 ");
    	lons.add("113.87596761067708 "); lats.add(" 22.57145697699653  ");
    	lons.add("113.87602593315972 "); lats.add(" 22.571434461805556 ");
    	lons.add("113.87609049479167 "); lats.add(" 22.57139594184028  ");
    	lons.add("113.87614773220486 "); lats.add(" 22.571316731770832 ");
    	lons.add("113.87622287326388 "); lats.add(" 22.57126953125     ");
    	lons.add("113.87632975260416 "); lats.add(" 22.571211480034723 ");
    	lons.add("113.87639919704861 "); lats.add(" 22.57117431640625  ");
    	lons.add("113.87648111979166 "); lats.add(" 22.571119520399307 ");
    	lons.add("113.87656060112847 "); lats.add(" 22.57104573567708  ");
    	lons.add("113.8766880967882  "); lats.add(" 22.570960286458334 ");
    	lons.add("113.87678765190972 "); lats.add(" 22.570897894965277 ");
    	lons.add("113.8768687608507  "); lats.add(" 22.5708447265625   ");
    	lons.add("113.8769447157118  "); lats.add(" 22.57080132378472  ");
    	lons.add("113.87704155815972 "); lats.add(" 22.57073296440972  ");
    	lons.add("113.87717041015625 "); lats.add(" 22.57065239800347  ");
    	lons.add("113.87727105034722 "); lats.add(" 22.570589735243054 ");
    	lons.add("113.87736518012153 "); lats.add(" 22.570520562065973 ");
    	lons.add("113.87745795355903 "); lats.add(" 22.570464680989584 ");
    	lons.add("113.87753445095485 "); lats.add(" 22.570411241319444 ");
    	lons.add("113.87760552300347 "); lats.add(" 22.57038818359375  ");
    	lons.add("113.87765109592014 "); lats.add(" 22.57033935546875  ");
    	lons.add("113.87778021918403 "); lats.add(" 22.57029812282986  ");
    	lons.add("113.87788547092013 "); lats.add(" 22.57022705078125  ");
    	lons.add("113.8779820421007  "); lats.add(" 22.57015597873264  ");
    	lons.add("113.87807020399306 "); lats.add(" 22.570074869791668 ");
    	lons.add("113.87818332248264 "); lats.add(" 22.569937608506944 ");
    	lons.add("113.87828721788195 "); lats.add(" 22.569888237847223 ");
    	lons.add("113.87839002821181 "); lats.add(" 22.569854329427084 ");
    	lons.add("113.87843451605903 "); lats.add(" 22.569761827256944 ");
    	lons.add("113.87852945963542 "); lats.add(" 22.569688313802082 ");
    	lons.add("113.87864718967013 "); lats.add(" 22.569631890190973 ");
    	lons.add("113.87866617838542 "); lats.add(" 22.569564073350694 ");
    	lons.add("113.87874891493055 "); lats.add(" 22.569523111979166 ");
    	lons.add("113.87884060329861 "); lats.add(" 22.569456108940972 ");
    	lons.add("113.87891194661458 "); lats.add(" 22.5694140625      ");
    	lons.add("113.87896809895834 "); lats.add(" 22.569371744791667 ");
    	lons.add("113.87902099609374 "); lats.add(" 22.569327528211804 ");
    	lons.add("113.87907931857639 "); lats.add(" 22.569290635850695 ");
    	lons.add("113.87909939236111 "); lats.add(" 22.5692529296875   ");
    	lons.add("113.87910264756944 "); lats.add(" 22.569210883246527 ");
    	lons.add("113.87909640842014 "); lats.add(" 22.569175618489584 ");
    	lons.add("113.8791099717882  "); lats.add(" 22.569177517361112 ");
    	lons.add("113.87910698784722 "); lats.add(" 22.569169650607638 ");
    	lons.add("113.87911566840278 "); lats.add(" 22.569176432291666 ");
    	lons.add("113.87912163628472 "); lats.add(" 22.5691748046875   ");
    	lons.add("113.87913140190972 "); lats.add(" 22.569170464409723 ");
    	lons.add("113.8791238064236  "); lats.add(" 22.56918701171875  ");
    	lons.add("113.87911187065973 "); lats.add(" 22.569195149739585 ");
    	lons.add("113.87909884982639 "); lats.add(" 22.569203559027777 ");
    	lons.add("113.87909261067708 "); lats.add(" 22.569210611979166 ");
    	lons.add("113.87907958984376 "); lats.add(" 22.569219563802083 ");
    	lons.add("113.8790673828125  "); lats.add(" 22.56923095703125  ");
    	lons.add("113.87905436197917 "); lats.add(" 22.569237196180556 ");
    	lons.add("113.8790402560764  "); lats.add(" 22.569244249131945 ");
    	lons.add("113.87903130425347 "); lats.add(" 22.569249945746527 ");
    	lons.add("113.87902018229167 "); lats.add(" 22.569261067708332 ");
    	lons.add("113.87901529947916 "); lats.add(" 22.569269476996528 ");
    	lons.add("113.879013671875   "); lats.add(" 22.569277072482638 ");
    	lons.add("113.87901801215278 "); lats.add(" 22.56927463107639  ");
    	lons.add("113.87902587890625 "); lats.add(" 22.569273003472222 ");
    	lons.add("113.879033203125   "); lats.add(" 22.56927490234375  ");
    	lons.add("113.8790402560764  "); lats.add(" 22.56927517361111  ");
    	lons.add("113.87904513888888 "); lats.add(" 22.569273003472222 ");
    	lons.add("113.87905571831597 "); lats.add(" 22.56927029079861  ");
    	lons.add("113.87907796223958 "); lats.add(" 22.569271104600695 ");
    	lons.add("113.87908501519097 "); lats.add(" 22.569267578125    ");
    	lons.add("113.87908637152778 "); lats.add(" 22.569273546006944 ");
    	lons.add("113.87908827039931 "); lats.add(" 22.56927734375     ");
    	lons.add("113.8790953233507  "); lats.add(" 22.569278428819445 ");
    	lons.add("113.87909749348958 "); lats.add(" 22.569277886284723 ");
    	lons.add("113.87909884982639 "); lats.add(" 22.569275987413196 ");
    	lons.add("113.87910400390625 "); lats.add(" 22.56927734375     ");
    	lons.add("113.87910264756944 "); lats.add(" 22.56927571614583  ");
    	lons.add("113.87910129123264 "); lats.add(" 22.569276529947917 ");
    	lons.add("113.87910319010416 "); lats.add(" 22.569278157552084 ");
    	lons.add("113.87910536024306 "); lats.add(" 22.569279242621526 ");
    	lons.add("113.87910617404513 "); lats.add(" 22.569280598958333 ");
    	lons.add("113.87910942925348 "); lats.add(" 22.56928276909722  ");
    	lons.add("113.87911051432292 "); lats.add(" 22.569284125434027 ");
    	lons.add("113.87911159939236 "); lats.add(" 22.56928466796875  ");
    	lons.add("113.87911295572917 "); lats.add(" 22.569286566840276 ");
    	lons.add("113.87911322699652 "); lats.add(" 22.569286566840276 ");
    	lons.add("113.87911187065973 "); lats.add(" 22.569285481770834 ");
    	lons.add("113.87911187065973 "); lats.add(" 22.569286024305555 ");
    	lons.add("113.87911214192708 "); lats.add(" 22.569286295572915 ");
    	lons.add("113.8791126844618  "); lats.add(" 22.569287109375    ");
    	lons.add("113.87911295572917 "); lats.add(" 22.569287109375    ");
    	lons.add("113.87911295572917 "); lats.add(" 22.569286566840276 ");
    	lons.add("113.87911376953124 "); lats.add(" 22.569287109375    ");
    	lons.add("113.87911431206597 "); lats.add(" 22.569287651909722 ");
    	lons.add("113.87911431206597 "); lats.add(" 22.569287923177082 ");
    	lons.add("113.87911404079861 "); lats.add(" 22.56928955078125  ");
    	lons.add("113.8791148546007  "); lats.add(" 22.569286024305555 ");
    	lons.add("113.87912055121528 "); lats.add(" 22.569281141493054 ");
    	lons.add("113.8791330295139  "); lats.add(" 22.569281141493054 ");
    	lons.add("113.87913981119792 "); lats.add(" 22.56927517361111  ");
    	lons.add("113.87915418836806 "); lats.add(" 22.56926703559028  ");
    	lons.add("113.8791712782118  "); lats.add(" 22.56925048828125  ");
    	lons.add("113.8791908094618  "); lats.add(" 22.569231228298612 ");
    	lons.add("113.87920844184028 "); lats.add(" 22.569211697048612 ");
    	lons.add("113.87922634548612 "); lats.add(" 22.569195963541667 ");
    	lons.add("113.87925103081598 "); lats.add(" 22.56918240017361  ");
    	lons.add("113.8792843967014  "); lats.add(" 22.56916042751736  ");
    	lons.add("113.87931423611111 "); lats.add(" 22.56914089626736  ");
    	lons.add("113.87933539496528 "); lats.add(" 22.569128689236113 ");
    	lons.add("113.87935872395833 "); lats.add(" 22.569116753472223 ");
    	lons.add("113.87937093098958 "); lats.add(" 22.569112413194443 ");
    	lons.add("113.87938693576389 "); lats.add(" 22.56911159939236  ");
    	lons.add("113.87939263237847 "); lats.add(" 22.569116482204862 ");
    	lons.add("113.87939615885416 "); lats.add(" 22.569115668402777 ");
    	lons.add("113.8793972439236  "); lats.add(" 22.569117024739583 ");
    	lons.add("113.87939643012153 "); lats.add(" 22.56911078559028  ");
    	lons.add("113.87939643012153 "); lats.add(" 22.569108072916666 ");
    	lons.add("113.8794007703993  "); lats.add(" 22.56910617404514  ");
    	lons.add("113.87939643012153 "); lats.add(" 22.569104546440972 ");
    	lons.add("113.87939615885416 "); lats.add(" 22.569102647569444 ");
    	lons.add("113.87939697265625 "); lats.add(" 22.569102105034723 ");
    	lons.add("113.87940266927083 "); lats.add(" 22.5691015625      ");
    	lons.add("113.87942301432291 "); lats.add(" 22.56909423828125  ");
    	lons.add("113.87942599826388 "); lats.add(" 22.569095865885416 ");
    	lons.add("113.87942409939237 "); lats.add(" 22.569098307291668 ");
    	lons.add("113.87941813151042 "); lats.add(" 22.569100477430556 ");
    	lons.add("113.87940863715278 "); lats.add(" 22.569102918836805 ");
    	lons.add("113.87939832899306 "); lats.add(" 22.569107530381945 ");
    	lons.add("113.87940104166667 "); lats.add(" 22.569105631510418 ");
    	lons.add("113.87940483940972 "); lats.add(" 22.569105088975693 ");
    	lons.add("113.87942464192709 "); lats.add(" 22.569093153211806 ");
    	lons.add("113.87944091796875 "); lats.add(" 22.56908393012153  ");
    	lons.add("113.87946343315973 "); lats.add(" 22.569071451822918 ");
    	lons.add("113.8794921875     "); lats.add(" 22.56905517578125  ");
    	lons.add("113.87952175564236 "); lats.add(" 22.56904052734375  ");
    	lons.add("113.87956298828125 "); lats.add(" 22.56901584201389  ");
    	lons.add("113.87960639105903 "); lats.add(" 22.5689794921875   ");
    	lons.add("113.8796497938368  "); lats.add(" 22.56894802517361  ");
    	lons.add("113.8796853298611  "); lats.add(" 22.56892388237847  ");
    	lons.add("113.87972439236111 "); lats.add(" 22.568899739583333 ");
    	lons.add("113.87977945963542 "); lats.add(" 22.568863932291666 ");
    	lons.add("113.87982177734375 "); lats.add(" 22.56884060329861  ");
    	lons.add("113.87978841145834 "); lats.add(" 22.568849283854167 ");
    	lons.add("113.87981065538195 "); lats.add(" 22.56880072699653  ");
    	lons.add("113.87990315755208 "); lats.add(" 22.56873996310764  ");
    	lons.add("113.87998209635417 "); lats.add(" 22.568687879774306 ");
    	lons.add("113.88005235460069 "); lats.add(" 22.568640950520834 ");
    	lons.add("113.88011664496528 "); lats.add(" 22.568616265190972 ");
    	lons.add("113.88020046657986 "); lats.add(" 22.56855767144097  ");
    	lons.add("113.88024386935764 "); lats.add(" 22.568484157986113 ");
    	lons.add("113.88030734592014 "); lats.add(" 22.568449164496528 ");
    	lons.add("113.88038357204861 "); lats.add(" 22.568403049045138 ");
    	lons.add("113.88042100694445 "); lats.add(" 22.56838134765625  ");
    	lons.add("113.88050103081598 "); lats.add(" 22.56832763671875  ");
    	lons.add("113.88059760199653 "); lats.add(" 22.568212619357638 ");
    	lons.add("113.88070095486111 "); lats.add(" 22.568140462239583 ");
    	lons.add("113.88077663845486 "); lats.add(" 22.568071831597223 ");
    	lons.add("113.88083767361111 "); lats.add(" 22.567994520399306 ");
    	lons.add("113.88094265407986 "); lats.add(" 22.567911512586807 ");
    	lons.add("113.88105278862847 "); lats.add(" 22.56783718532986  ");
    	lons.add("113.88115614149305 "); lats.add(" 22.567757161458335 ");
    	lons.add("113.88124701605902 "); lats.add(" 22.567664930555555 ");
    	lons.add("113.88134114583333 "); lats.add(" 22.567579210069443 ");
    	lons.add("113.88145453559028 "); lats.add(" 22.567489420572915 ");
    	lons.add("113.8815798611111  "); lats.add(" 22.567392035590277 ");
    	lons.add("113.88169379340277 "); lats.add(" 22.56729546440972  ");
    	lons.add("113.8818031141493  "); lats.add(" 22.56718722873264  ");
    	lons.add("113.881923828125   "); lats.add(" 22.567090657552082 ");
    	lons.add("113.88204345703124 "); lats.add(" 22.566995171440972 ");
    	lons.add("113.88214491102431 "); lats.add(" 22.566917860243056 ");
    	lons.add("113.88225504557292 "); lats.add(" 22.56684136284722  ");
    	lons.add("113.88233181423611 "); lats.add(" 22.566761338975695 ");
    	lons.add("113.88240614149305 "); lats.add(" 22.56669135199653  ");
    	lons.add("113.88245225694445 "); lats.add(" 22.56659613715278  ");
    	lons.add("113.88253336588542 "); lats.add(" 22.566524251302084 ");
    	lons.add("113.88258056640625 "); lats.add(" 22.566449381510417 ");
    	lons.add("113.88263075086806 "); lats.add(" 22.56640570746528  ");
    	lons.add("113.88268581814236 "); lats.add(" 22.566369357638887 ");
    	lons.add("113.88270806206597 "); lats.add(" 22.566346571180556 ");
    	lons.add("113.88275472005208 "); lats.add(" 22.566327582465277 ");
    	lons.add("113.88277452256945 "); lats.add(" 22.56631049262153  ");
    	lons.add("113.88280219184028 "); lats.add(" 22.56629096137153  ");
    	lons.add("113.88282199435764 "); lats.add(" 22.56627712673611  ");
    	lons.add("113.88285264756945 "); lats.add(" 22.566268717447915 ");
    	lons.add("113.8828662109375  "); lats.add(" 22.56626898871528  ");
    	lons.add("113.88286702473958 "); lats.add(" 22.56626980251736  ");
    	lons.add("113.88286702473958 "); lats.add(" 22.56627712673611  ");
    	lons.add("113.88287489149306 "); lats.add(" 22.566267632378473 ");
    	lons.add("113.88285346137152 "); lats.add(" 22.566268446180555 ");
    	lons.add("113.8828648546007  "); lats.add(" 22.566285536024306 ");
    	lons.add("113.88286187065972 "); lats.add(" 22.566278754340278 ");
    	lons.add("113.88285942925347 "); lats.add(" 22.566278211805557 ");
    	lons.add("113.88284776475695 "); lats.add(" 22.566278211805557 ");
    	lons.add("113.8828306749132  "); lats.add(" 22.566258680555556 ");
    	lons.add("113.8828298611111  "); lats.add(" 22.566250813802082 ");
    	lons.add("113.88284396701388 "); lats.add(" 22.566254340277776 ");
    	lons.add("113.88287868923611 "); lats.add(" 22.56627224392361  ");
    	lons.add("113.88289930555555 "); lats.add(" 22.566271430121528 ");
    	lons.add("113.88290852864583 "); lats.add(" 22.566276041666665 ");
    	lons.add("113.88291178385417 "); lats.add(" 22.56627658420139  ");
    	lons.add("113.88291531032986 "); lats.add(" 22.566280924479166 ");
    	lons.add("113.88291910807291 "); lats.add(" 22.566282823350694 ");
    	lons.add("113.8829136827257  "); lats.add(" 22.566280924479166 ");
    	lons.add("113.88291097005208 "); lats.add(" 22.566278754340278 ");
    	lons.add("113.88290635850694 "); lats.add(" 22.566270616319443 ");
    	lons.add("113.8829150390625  "); lats.add(" 22.566268717447915 ");
    	lons.add("113.8829163953993  "); lats.add(" 22.566265733506945 ");
    	lons.add("113.8829136827257  "); lats.add(" 22.56626491970486  ");
    	lons.add("113.88292046440972 "); lats.add(" 22.566255967881943 ");
    	lons.add("113.88292209201389 "); lats.add(" 22.56625244140625  ");
    	lons.add("113.88291937934028 "); lats.add(" 22.56625244140625  ");
    	lons.add("113.88292046440972 "); lats.add(" 22.566252983940974 ");
    	lons.add("113.882919921875   "); lats.add(" 22.56625           ");
    	lons.add("113.88291205512152 "); lats.add(" 22.566243489583332 ");
    	lons.add("113.8829052734375  "); lats.add(" 22.56624213324653  ");
    	lons.add("113.88290120442709 "); lats.add(" 22.56624321831597  ");
    	lons.add("113.88288302951389 "); lats.add(" 22.566220703125    ");
    	lons.add("113.8828795030382  "); lats.add(" 22.566226671006945 ");
    	lons.add("113.88288275824652 "); lats.add(" 22.566224772135417 ");
    	lons.add("113.88288519965278 "); lats.add(" 22.56622775607639  ");
    	lons.add("113.88289577907986 "); lats.add(" 22.566219618055555 ");
    	lons.add("113.88290283203125 "); lats.add(" 22.566214192708333 ");
    	lons.add("113.88290147569444 "); lats.add(" 22.566207411024305 ");
    	lons.add("113.88290337456597 "); lats.add(" 22.56620849609375  ");
    	lons.add("113.88289849175347 "); lats.add(" 22.566210123697918 ");
    	lons.add("113.88289767795139 "); lats.add(" 22.56621527777778  ");
    	lons.add("113.8829017469618  "); lats.add(" 22.566216634114582 ");
    	lons.add("113.88291341145833 "); lats.add(" 22.5662109375      ");
    	lons.add("113.8829248046875  "); lats.add(" 22.566207139756944 ");
    	lons.add("113.8829372829861  "); lats.add(" 22.566197645399306 ");
    	lons.add("113.88295328776042 "); lats.add(" 22.5661865234375   ");
    	lons.add("113.88298204210069 "); lats.add(" 22.566170789930556 ");
    	lons.add("113.88300944010416 "); lats.add(" 22.566149359809028 ");
    	lons.add("113.88304606119792 "); lats.add(" 22.566126302083333 ");
    	lons.add("113.88309814453125 "); lats.add(" 22.566104058159723 ");
    	lons.add("113.88314805772569 "); lats.add(" 22.56607367621528  ");
    	lons.add("113.88320149739583 "); lats.add(" 22.566042209201388 ");
    	lons.add("113.88323784722222 "); lats.add(" 22.566017252604166 ");
    	lons.add("113.88328830295139 "); lats.add(" 22.565997178819444 ");
    	lons.add("113.88333821614583 "); lats.add(" 22.565943196614583 ");
    	lons.add("113.88336263020834 "); lats.add(" 22.565882161458333 ");
    	lons.add("113.88342041015625 "); lats.add(" 22.5658251953125   ");
    	lons.add("113.88351399739584 "); lats.add(" 22.56577690972222  ");
    	lons.add("113.88356065538194 "); lats.add(" 22.565690375434027 ");
    	lons.add("113.88363037109374 "); lats.add(" 22.56562527126736  ");
    	lons.add("113.88367458767361 "); lats.add(" 22.565570475260415 ");
    	lons.add("113.88374376085069 "); lats.add(" 22.565509168836805 ");
    	lons.add("113.8838357204861  "); lats.add(" 22.565447591145833 ");



    	for(int i=0; i < lons.size(); i++) {	
    	    String url = "http://"+ip+"UploadLocation.do";
    	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'1','longitude':"
    				+lons.get(i).trim()+",'latitude':"+lats.get(i).trim()+ "}}";
    	    String t1 = new DateUtil().getTm();
    	    String ress =MyHttpRequest.sendGet(url, par,"utf-8",false);
    	   // logger.info(ress);
    	    UploadLocationRes res = JSONObject.parseObject(ress,UploadLocationRes.class);
    	    String t2 = new DateUtil().getTm();
    	    if(res == null || res.getBody() == null) continue;
    	    
    	    logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	    //logger.info(res.getBody());
    	    
    	}
    }
    
}