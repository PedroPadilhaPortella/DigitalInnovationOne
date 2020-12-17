# Break, Next e Redo

["laranja", "maca", "pera", "banana"].each do |fruta|
    puts fruta
    break if fruta == "pera" 
end


["laranja", "maca", "pera", "banana"].each do |fruta|
    next if fruta == "pera"
    puts fruta
end

loop do
    puts "digite um numero:"
    n = gets.to_i 
    redo if n > 10
    break
end