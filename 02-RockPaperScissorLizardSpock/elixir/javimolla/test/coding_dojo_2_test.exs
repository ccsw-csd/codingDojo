defmodule CodingDojo2Test do
  use ExUnit.Case
  import CodingDojo2
  doctest CodingDojo2

  test "same move returns draw" do
    assert play(:scissors, :scissors) == :draw
    assert play(:paper, :paper) == :draw
    assert play(:rock, :rock) == :draw
    assert play(:lizard, :lizard) == :draw
    assert play(:spock, :spock) == :draw
  end

  test "scissors cut paper", do: assert play(:scissors, :paper) == :win
  test " paper covers rock", do: assert play(:paper, :rock) == :win
  test " rock crushes lizard", do: assert play(:rock, :lizard) == :win
  test " lizard poisons spock", do: assert play(:lizard, :spock) == :win
  test " spock smashes scissors", do: assert play(:spock, :scissors) == :win
  test " scissors decapitates lizard", do: assert play(:scissors, :lizard) == :win
  test " lizard eats paper", do: assert play(:lizard, :paper) == :win
  test " paper disproves spock", do: assert play(:paper, :spock) == :win
  test " spock vapirizes rock", do: assert play(:spock, :rock) == :win
  test "rock crushes scissors", do: assert play(:rock, :scissors) == :win
  
  test " any move returns lose" do
  	assert play(:paper, :scissors) == :lose
  	assert play(:rock, :paper) == :lose

  	assert play(:lizard, :rock) == :lose
  	assert play(:spock, :lizard) == :lose
  	assert play(:scissors, :spock) == :lose
  	assert play(:lizard, :scissors) == :lose
  	assert play(:paper, :lizard) == :lose
  	assert play(:spock, :paper) == :lose
  	assert play(:rock, :spock) == :lose
  	assert play(:scissors, :rock) == :lose
  end
end
