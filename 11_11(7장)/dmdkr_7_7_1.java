package sam;

import java.util.HashMap;
import java.util.Scanner;

class Location {
    int lat, lon; // 위도(latitude), 경도(longitude)

    public Location(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}


public class dmdkr_7_7_1 {
	public static void main(String[] args) {
		
		 Scanner sr = new Scanner(System.in);
	        HashMap<String, Location> city = new HashMap<>();

	        // 도시, 경도, 위도 4개 입력받기
	        System.out.println("도시, 경도, 위도를 입력:");
	        for (int i = 0; i < 4; i++) {
	            String name = sr.next();
	            int lat = sr.nextInt();
	            int lon = sr.nextInt();
	            city.put(name, new Location(lat, lon));
	        }

	        System.out.println("---------------------ㅡ-------------");

	        // 기록된 모든 도시의 경도와 위도 출력
	        System.out.println("저장된 도시와 위치:");
	        for (String key : city.keySet()) {
	            Location town = city.get(key);
	            System.out.println(String.format("%-6s %-6d %-6d", key, town.getLat(), town.getLon()));
	        }

	        System.out.println("---------------------ㅡ-------------");

	        // 그만이라는 입력이 들어오기 전까지 입력한 도시 출력
	        System.out.println("도시 이름을 입력하라. '그만'을 입력하면 종료한다.");
	        while (true) {
	            String input = sr.next(); 
	            if (input.equals("그만")) { 
	                break;
	            }

	            // 입력된 도시 정보 출력
	            if (city.containsKey(input)) {
	                Location town = city.get(input);
	                System.out.println(String.format("%-6s %-6d %-6d", input, town.getLat(), town.getLon()));
	            } else {
	                System.out.println(input + "는(은) 등록되지 않은 도시입니다.");
	            }
	        }

	        System.out.println("프로그램을 종료합니다.");
	        sr.close();
	}
}
