defmodule Potter do
  @moduledoc """
  Documentation for Potter.
  """

  def price([]) do
    0
  end 

  def price(books) when is_list(books) and length(books) == 1 do
    8
  end

  def price(books) when is_list(books) do
    # Los agrupo según el libro
    # [0, 0, 1, 2, 2, 3] pasaría a ser [%{0 => [0, 0]}, %{1 => [1]} ...]
    Enum.group_by(books, fn(book) -> book end)
      |> Enum.map(fn(x) -> 
        # Me quedo sólo con la parte de listado ya que se ha convertido en un map
        # [%{0 => [0, 0]}, %{1 => [1]} ...] pasaría a ser [[0, 0], [1], ...]
        elem(x, 1)
      end)
    |> length
    |> get_lists(books)
    |> Enum.filter(fn(x) ->
      x != nil
    end)
    |> Enum.map(fn(x) ->
      pricep(x)
    end)
    |> Enum.min
  end

  defp get_lists(0, _) do
    []
  end
  
  defp get_lists(max_books, books) do
    [get_list(max_books, books) | get_lists(max_books - 1, books)]
  end

  defp get_list(_, []) do
    []
  end

  defp get_list(1, books) do
    Enum.chunk books, 1
  end

  defp get_list(max_books, books) do
    uniques = books
      |> Enum.uniq
      |> Enum.slice(0..max_books-1)
    rest = get_list(max_books, books -- uniques)
    case length(rest) do
      0 -> [uniques]
      _ -> [uniques | rest]
    end
  end

  def get_lists(_, index, max) when index == max do
    []
  end

  def get_lists(list, index, max) do
    [Enum.map(list, fn(x) -> 
      case length(x) > index do
        true -> 
          {value, _} = List.pop_at x, index
          value
        false -> nil
      end
    end) | get_lists(list, index + 1, max)]
  end

  defp pricep(books) do
    books
    |> Enum.scan(0, fn(x, price) -> 
      num_books = Enum.filter(x, fn(x) -> 
          x != nil 
        end)
        |> length
      
      # Aplicamos un descuento u otro dependiendo del número de libros distintos
      price_per_book = 8 * (case num_books do
        1 -> 1
        2 -> 0.95
        3 -> 0.9
        4 -> 0.8
        5 -> 0.75
      end)
      price + (num_books * price_per_book)
    end)
    |> Enum.max
  end
end