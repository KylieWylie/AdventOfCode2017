public class Day1a {

	public static void main(String[] args) {		
		String toAdd = "";
		int result = 0;
		
		//testing data
		System.out.println("~~~~~ Tests ~~~~~\n");
		
		String test1 = "1122";
		String test2 = "1111";
		String test3 = "1234";
		String test4 = "91212129";
		
		toAdd = ToAdd(test1);
		result = Add(toAdd);
		System.out.println("Result: " + result);
		
		toAdd = ToAdd(test2);
		result = Add(toAdd);
		System.out.println("Result: " + result);
		
		toAdd = ToAdd(test3);
		result = Add(toAdd);
		System.out.println("Result: " + result);
		
		toAdd = ToAdd(test4);
		result = Add(toAdd);
		System.out.println("Result: " + result);
		
		//actual numberinos		
		System.out.println("\n~~~~ Real dude ~~~~\n");
		
		//the input... should have just read this in as a text file...
		String nums = "8231753674683997878179259195565332579493378483264978184143341284379682788518559178822"
				+ "22512662542831811539663268114187195289429189836478189892929261479288488324935672874199322"
				+ "48891679282322613251234475698299329512682929539287667557797618379938125285274844872981177"
				+ "39869189415599461746944992651752768158611996715467871381527675219481185217357632445748912"
				+ "72648766988187612919293299528277784849656125983978118871923395161918838853269851929814211"
				+ "28537769425452118591341852317689528884624716428515883684457614892257869197789838481138337"
				+ "73768236969923939838755997989537648222217996381757542964844337285428654375499359997792679"
				+ "25688137896785237684881279576111813928815279992117687425637761595275826884413957962275496"
				+ "54618848626474234919189136288487487565954631915855553858493357422248554737694112123764465"
				+ "91654846168189278959857681336724221434846946124915271196433144335482787432683848594487648"
				+ "47753249895257251511886447562182811827491129839674821313642635776999131466164261278684713"
				+ "54859698892371938227181112695617415634791168323644857247162421762886423718495696645941946"
				+ "74763319687735723517614962575592111286177553435651952853878775431234327919595595658641534"
				+ "76545548956193454847429125438722975147288342341319684516275271692519986659188331363884647"
				+ "43211615698925185743462267513663153111457774487818622221269234493118385646858826958893975"
				+ "31413937666673233451216968414288135984394249684886554812761191289485457945866524228415191"
				+ "54916855795763338699193118677384386999928446877386622197687399816881894439966146396365878"
				+ "48217962729871552781953555793867681567188136245592645748361344197251878815146658344413596"
				+ "44955768658663278765363789664721736533517774292478192143934318399418188298753351815388561"
				+ "35952853377899629627936639438645554444692265397672511388984274918236125358243331935119386"
				+ "27884331138527825961611489922335581446929137917148595166534219178412957491634697514798354"
				+ "92713392861519993791967927773114713888458982796514977717987598165486967786989991998142488"
				+ "63116869796381615637421622438619394156635854326664651624785443535694156649284121342491568"
				+ "23949289591164114579678976144574972794726612295486127771559983586189452223265581764869446"
				+ "95689777438164612198225816646583996426313832539918";
		
		toAdd = ToAdd(nums);
		result = Add(toAdd);
		System.out.println("Result: " + result);
	}
	
	//returns a string of all the numbers to add together
	public static String ToAdd(String nums) {
		char temp;
		char compare;
		
		String toAdd = "";
		
		for(int i = 0; i < nums.length()-1; i++) {
			temp = nums.charAt(i);
			compare = nums.charAt(i+1);
			
			if(temp == compare) {
				toAdd += temp;
			}
			
			if(i == nums.length()-2) {
				temp = nums.charAt(0);		
				compare = nums.charAt(nums.length()-1);
				
				if(temp == compare) {
					toAdd += temp;
				}
			}
		}
		
		return toAdd;
	}

	//returns the numbers added together
	public static int Add(String toAdd) {	
		int result = 0;
		
		for(int i = 0; i < toAdd.length(); i++) {
			result += Integer.parseInt(Character.toString(toAdd.charAt(i)));
		}
		
		return result;
	}
}