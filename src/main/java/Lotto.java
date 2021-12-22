public class Lotto {
    private int lottoId;
    private int[] winning_numbers;
    private Winners winners;

    public int getLottoId() {
        return lottoId;
    }

    public void setLottoId(int lottoId) {
        this.lottoId = lottoId;
    }

    public int[] getWinning_numbers() {
        return winning_numbers;
    }

    public void setWinning_numbers(int[] winning_numbers) {
        this.winning_numbers = winning_numbers;
    }

    public Winners getWinners() {
        return winners;
    }

    public void setWinners(Winners winners) {
        this.winners = winners;
    }
}
