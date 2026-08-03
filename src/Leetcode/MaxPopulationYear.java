public class MaxPopulationYear {
    public int maximumPopulation(int[][] logs) {

        int earliest_year=1950;
        int n= logs.length;
        int maxPopulation = 0;
        for(int year = 1950;year < 2050;year++){
            int alivecount = 0;
            for(int i=0;i<logs.length;i++){

                int birth = logs[i][0];
                int death = logs[i][1];

                if(birth <= year && year < death)
                    alivecount++;
            }
            if(alivecount > maxPopulation){
                maxPopulation = alivecount;
                earliest_year = year;
            }

        }

        return earliest_year;

    }
    public static void main(String[] args){

        int[][] arr = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };
        MaxPopulationYear obj = new MaxPopulationYear();
        int result = obj.maximumPopulation(arr);
        System.out.println("The earliest year is: "+result);
    }
}

