package Project1;

public class PlayerStatus {
    private String nickname;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionX;
    private double positionY;
    private static String gameName;

    public void initPlayer(String nickname){
        this.nickname = nickname;
    }
    public void initPLayer(String nickname, int lives){
        this.nickname = nickname;
        this.lives = lives;
    }
    public void initPlayer(String nickname, int lives, int score){
        this.nickname = nickname;
        this.lives = lives;
        this.score = score;
    }
    private static boolean isPrime(int n){
        boolean isPrime = true;
        for(int i = 2; i < n / 2; i++){
            if (n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    private static boolean isPerfect(int n){
        boolean isPerfect = false;
        int sum = 0;
        for(int i = 1; i <= n / 2; i++){
            if(n % i == 0){
                sum += i;
            }
        }
        if (sum == n){
            isPerfect = true;
        }
        return isPerfect;
    }

    private static boolean isTrap(int n){
        boolean isTrap = false;
        int aux = n;
        int sumN = 0;
        while( aux != 0){
            int uC = aux % 10;
            sumN += uC;
            aux /= 10;
        }
        if( (n % 2 == 0) && (sumN % 3 == 0)){
            isTrap = true;
        }
        return isTrap;
    }

    public void findArtifact(int artifactCode){
        if (isPerfect(artifactCode)){
            this.score += 5000;
            this.lives += 1;
            this.health += 100;
        }else if (isPrime(artifactCode)){
            this.score += 1000;
            this.lives += 2;
            if(this.health <= 75) {
                this.health += 25;
            } else {
                this.health = 100;
            }
        }else if (isTrap(artifactCode)){
            this.score -= 3000;
            this.health -= 25;
            if (this.health <= 0){
                this.lives -= 1;
                this.health = 100;
            }
        } else {
            this.score += artifactCode;
        }
    }
    public boolean setWeaponInHand(String weaponInHand){
        weaponInHand = weaponInHand.toLowerCase();
        boolean isWeaponChanged = false;
        switch (weaponInHand){
            case "knife":
                if(score >= 1000){
                    this.weaponInHand = weaponInHand;
                    score -= 1000;
                    isWeaponChanged = true;
                    System.out.println("The weapon has been changed to \"knife\" successfully!");
                } else {
                    System.out.println("You don't have enough money for \"knife\"!");
                }
                break;
            case"sniper":
                if(score >= 10000){
                    this.weaponInHand = weaponInHand;
                    score -= 10000;
                    isWeaponChanged = true;
                    System.out.println("The weapon has been changed to \"sniper\" successfully!");
                } else {
                    System.out.println("You don't have enough money for \"sniper\"!");
                }
                break;
            case "kalashnikov":
                if(score >= 20000){
                    this.weaponInHand = weaponInHand;
                    score -= 20000;
                    isWeaponChanged = true;
                    System.out.println("The weapon has been changed to \"kalashnikov\" successfully!");
                } else {
                    System.out.println("You don't have enough money for \"kalashnikov\"!");
                }
                break;
            default:
                System.out.println("Weapon chosen is not a valid one.");
                break;
        }
        return isWeaponChanged;
    }
    public String getWeaponInHand(){
        return weaponInHand;
    }
    public double getPositionX(){
        return positionX;
    }
    public int getScore(){
        return score;
    }
    public int getHealth(){
        return health;
    }
    public void setPositionX(double newPositionX){
        this.positionX = newPositionX;
    }
    public double getPositionY(){
        return positionY;
    }
    public void setPositionY(double newPositionY){
        this.positionY = newPositionY;
    }
    protected static String getGameName(){
        return gameName;
    }
    protected static void setGameName(String newGameName){
        gameName = newGameName;
    }
    public void movePlayerTo(double positionX, double positionY){
        setPositionX(positionX);
        setPositionY(positionY);
    }
    public String getNickName(){
        return "Player nickname is: " + nickname;
    }
    private static boolean isWeaponPowerForLongDistance(String weapon1, String weapon2) {
        if (weapon1.equals("sniper") && weapon2.equals("knife")) {
            return true;
        }
        if (weapon1.equals("sniper") && weapon2.equals("kalashnikov")) {
            return true;
        }
        if (weapon1.equals("kalashnikov") && weapon2.equals("sniper")) {
            return false;
        }
        if (weapon1.equals("kalashnikov") && weapon2.equals("knife")) {
            return true;
        }
        if (weapon1.equals("knife") && weapon2.equals("kalashnikov")) {
            return false;
        }
        if (weapon1.equals("knife") && weapon2.equals("sniper")) {
            return false;
        }
        return false;
    }

    private static boolean isWeaponPowerForShortDistance(String weapon1, String weapon2) {
        if (weapon1.equals("sniper") && weapon2.equals("knife")) {
            return true;
        }
        if (weapon1.equals("sniper") && weapon2.equals("kalashnikov")) {
            return false;
        }
        if (weapon1.equals("kalashnikov") && weapon2.equals("sniper")) {
            return true;
        }
        if (weapon1.equals("kalashnikov") && weapon2.equals("knife")) {
            return true;
        }
        if (weapon1.equals("knife") && weapon2.equals("kalashnikov")) {
            return false;
        }
        if (weapon1.equals("knife") && weapon2.equals("sniper")) {
            return false;
        }
        return false;
    }

    public boolean shouldAttackOpponent(PlayerStatus opponent){
        if(opponent.weaponInHand.equals(weaponInHand)){
            int sumA = ((3 * health + score) / 1000) / 4;
            int sumB = ((3 * opponent.health + opponent.score) / 1000) / 4;
            return sumA > sumB;
        } else{
            double distance = Math.sqrt(Math.pow(positionX - opponent.positionX, 2) + Math.pow(positionY - opponent.positionY,2));
            if(distance > 1000){
                System.out.println("You are long away from your opponent");
                return isWeaponPowerForLongDistance(weaponInHand, opponent.weaponInHand);
            } else {
                System.out.println("You are close to your opponent");
                return isWeaponPowerForShortDistance(weaponInHand, opponent.weaponInHand);
            }
        }
    }
}

