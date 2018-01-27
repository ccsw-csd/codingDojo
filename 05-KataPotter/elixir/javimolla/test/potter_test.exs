defmodule PotterTest do
  use ExUnit.Case
  doctest Potter

  test "testBasics" do
    assert 0 == Potter.price([])
    assert 8 == Potter.price([0])
    assert 8 == Potter.price([1])
    assert 8 == Potter.price([2])
    assert 8 == Potter.price([3])
    assert 8 == Potter.price([4])
    assert 8 * 2 == Potter.price([0, 0])
    assert 8 * 3 == Potter.price([1, 1, 1])
  end
   
  test "testSimpleDiscounts" do
    assert 8 * 2 * 0.95 == Potter.price([0, 1])
    assert 8 * 3 * 0.9 == Potter.price([0, 2, 4])
    assert 8 * 4 * 0.8 == Potter.price([0, 1, 2, 4])
    assert 8 * 5 * 0.75 == Potter.price([0, 1, 2, 3, 4])
  end
  
  test "testSeveralDiscounts" do
    assert 8 + (8 * 2 * 0.95) == Potter.price([0, 0, 1])
    assert 2 * (8 * 2 * 0.95) == Potter.price([0, 0, 1, 1])
    assert (8 * 4 * 0.8) + (8 * 2 * 0.95) == Potter.price([0, 0, 1, 2, 2, 3])
    assert 8 + (8 * 5 * 0.75) == Potter.price([0, 1, 1, 2, 3, 4])
  end
  
  test "testEdgeCases" do
    assert 2 * (8 * 4 * 0.8) == Potter.price([0, 0, 1, 1, 2, 2, 3, 4])
    # Antes era 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8) pero eso es mayor 
    # que 4 * (8 * 5 * 0.75) + (8 * 3 * 0.9) 
    assert 4 * (8 * 5 * 0.75) + (8 * 3 * 0.9) == 
      Potter.price([0, 0, 0, 0, 0, 
           1, 1, 1, 1, 1, 
           2, 2, 2, 2, 
           3, 3, 3, 3, 3, 
           4, 4, 4, 4])
  end
end
