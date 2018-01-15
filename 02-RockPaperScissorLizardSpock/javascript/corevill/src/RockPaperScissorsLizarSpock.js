var RESULTS = ["DRAW", "WIN PLAYER ONE", "WIN PLAYER TWO"];

var MOVES = {
  SCISSORS: 0,
  PAPER: 1,
  ROCK: 2,
  LIZARD: 3,
  SPOCK: 4
};

var winPlayerOne = function(player1, player2){
  var sub = player1 - player2;
  return sub > 0 && isPair(sub) || sub < 0 && !isPair(sub);
}

var isPair = function(number){
  return number % 2 == 0;
}

var play = function(player1, player2) {
  if(player1 === player2)
    return RESULTS[0];
  return RESULTS[winPlayerOne(player1, player2) ? 1 : 2];
}
