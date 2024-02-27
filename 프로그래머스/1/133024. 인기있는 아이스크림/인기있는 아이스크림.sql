# 아이스크림 맛
SELECT FLAVOR

# 상반기에 판매된
FROM FIRST_HALF

# 총 주문량 기준 내림차순, 총 주문량 같다면 출하 번호 기준 오름차순
ORDER BY TOTAL_ORDER desc, SHIPMENT_ID;
