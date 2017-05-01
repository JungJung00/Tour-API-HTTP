package Definition;

import java.util.Date;

/**
 * Created by Jeong Taegyun on 2017-04-17.
 */

public class Festival {
    private int contentid;
    private String addr1;        // 광역시/도 시/군/구 읍/면/동/리 대로/로/길 건물번호
    private String firstImage;   // 원본 대표이미지, URL 응답
    private double mapX;          // GPS X 좌표, WGS84 위도 좌표
    private double mapY;          // GPS Y 좌표, WGS84 경도 좌표
    private String tel;            // 연락처명 연락처 예) 농업기술센터 체험농업팀 031-940-5288, 5281
    private String title;          // 콘텐츠 제목
    // private String eventStartDate;  // 축제 시작일 (yyyyMMdd)
    // private String eventEndDate;    // 축제 종료일 (yyyyMMdd)
    private String festivalPeriod;   // 축제 시작일 ~ 종료일 (yyyyMMdd ~ yyyyMMdd)

    // locationBasedList
    public Festival(int id, String addr1, String img, double x, double y, String tel, String title){
        contentid = id;
        this.addr1 = addr1;
        firstImage = img;
        mapX = x;
        mapY = y;
        this.tel = tel;
        this.title = title;
        // 축제 시작, 종료일은 detailIntro API로 설정
    }

    // searchFestival
    public Festival(int id, String addr1, String img, double x, double y, String tel, String title, String festivalPeriod){
        contentid = id;
        this.addr1 = addr1;
        firstImage = img;
        mapX = x;
        mapY = y;
        this.tel = tel;
        this.title = title;
        this.festivalPeriod = festivalPeriod;
    }

    public String getAddr1() { return addr1; }

    public int getContentid() {
        return contentid;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public double getMapX() {
        return mapX;
    }

    public double getMapY() {
        return mapY;
    }

    public String getTel() {
        return tel;
    }

    public String getTitle() {
        return title;
    }

    public String getFestivalPeriod() {
        return festivalPeriod;
    }

    public void setFestivalPeriod(String festivalPeriod) {
        this.festivalPeriod = festivalPeriod;
    }
}
