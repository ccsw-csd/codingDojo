describe("Rock Paper Scissors Lizar Spock game", function() {
  var DRAW;
  var WIN_PLAYER_1;
  var WIN_PLAYER_2;

  beforeEach(function() {
    DRAW = RESULTS[0];
    WIN_PLAYER_1 = RESULTS[1];
    WIN_PLAYER_2 = RESULTS[2];
  });

  it("ROCK crushed LIZARD", function () {
      expect(play(MOVES.ROCK,MOVES.LIZARD)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.LIZARD, MOVES.ROCK)).toEqual(WIN_PLAYER_2);
  });

  it("SCISSORS decapite LIZARD", function () {
      expect(play(MOVES.SCISSORS,MOVES.LIZARD)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.LIZARD, MOVES.SCISSORS)).toEqual(WIN_PLAYER_2);
  });

  it("LIZARD poisons SPOCK", function () {
      expect(play(MOVES.LIZARD, MOVES.SPOCK)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.SPOCK, MOVES.LIZARD)).toEqual(WIN_PLAYER_2);
  });

  it("PAPER disproves SPOCK", function () {
      expect(play(MOVES.PAPER, MOVES.SPOCK)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.SPOCK, MOVES.PAPER)).toEqual(WIN_PLAYER_2);
  });

  it("PAPER vaporizes ROCK", function () {
      expect(play(MOVES.PAPER, MOVES.ROCK)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.ROCK, MOVES.SPOCK)).toEqual(WIN_PLAYER_2);
  });

  it("SPOCK bends SCISSORS", function () {
      expect(play(MOVES.SPOCK, MOVES.SCISSORS)).toEqual(WIN_PLAYER_1);
      expect(play(MOVES.SCISSORS, MOVES.SPOCK)).toEqual(WIN_PLAYER_2);
  });

  it("Equal moves is a draw", function () {
      expect(play(MOVES.ROCK, MOVES.ROCK)).toEqual(DRAW);
      expect(play(MOVES.PAPER, MOVES.PAPER)).toEqual(DRAW);
      expect(play(MOVES.SCISSORS, MOVES.SCISSORS)).toEqual(DRAW);
      expect(play(MOVES.LIZARD, MOVES.LIZARD)).toEqual(DRAW);
      expect(play(MOVES.SPOCK, MOVES.SPOCK)).toEqual(DRAW);
  });
});
