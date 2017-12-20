package adventofcode2k17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Challenges {

	private static int InverseCaptcha(String seq) {
		int cantidad = 0;
		for (int i = 0; i < seq.length(); i++) {

			if (i == seq.length() - 1) {
				if (seq.charAt(i) == seq.charAt(0))
					cantidad += seq.charAt(i) - '0';

				break;
			}

			if (seq.charAt(i) == seq.charAt(i + 1)) {
				cantidad += seq.charAt(i) - '0';
			}
		}

		return cantidad;
	}

	private static int CorruptionChecksum(String input) {
		int checksum = 0;

		Scanner scan = new Scanner(input);

		while (scan.hasNext()) {
			String[] row = scan.nextLine().split("\\s+");

			List<Integer> list = Arrays.stream(row).map(Integer::valueOf).collect(Collectors.toList());
			
			checksum += Collections.max(list) - Collections.min(list);
		}

		return checksum;
	}

	public static void main(String[] args) {
//		String input = "157	564	120	495	194	520	510	618	244	443	471	473	612	149	506	138\n" + "7 5 3\n" + "2 4 6 8";

		String input = "157	564	120	495	194	520	510	618	244	443	471	473	612	149	506	138\n"
		+"1469	670	47	604	1500	238	1304	1426	54	749	1218	1409	60	51	1436	598\n"
		+"578	184	2760	3057	994	167	2149	191	2913	2404	213	1025	1815	588	2421	3138\n"
		+"935	850	726	155	178	170	275	791	1028	75	781	138	176	621	773	688\n"
		+"212	977	297	645	229	194	207	640	804	509	833	726	197	825	242	743\n"
		+"131	43	324	319	64	376	231	146	382	162	464	314	178	353	123	446\n"
		+"551	121	127	155	1197	288	1412	1285	557	137	145	1651	1549	1217	681	1649\n"
		+"1723	1789	5525	4890	3368	188	3369	4842	3259	2502	4825	163	146	2941	126	5594\n"
		+"311	2420	185	211	2659	2568	2461	231	2599	1369	821	506	2227	180	220	1372\n"
		+"197	4490	141	249	3615	3314	789	4407	169	352	4383	5070	5173	3115	132	3513\n"
		+"4228	2875	3717	504	114	2679	165	3568	3002	116	756	151	4027	261	4813	2760\n"
		+"651	3194	2975	2591	1019	835	3007	248	3028	1382	282	3242	296	270	3224	3304\n"
		+"1858	1650	1720	1848	95	313	500	1776	207	1186	72	259	281	1620	79	77\n"
		+"3841	3217	440	3481	3643	940	3794	4536	1994	4040	3527	202	193	1961	230	217\n"
		+"2837	2747	2856	426	72	78	2361	96	2784	2780	98	2041	2444	1267	2167	2480\n"
		+"411	178	4263	4690	3653	162	3201	4702	3129	2685	3716	147	3790	4888	79	165\n";
		
		System.out.println("Checksum is: " + CorruptionChecksum(input));
	}

}
